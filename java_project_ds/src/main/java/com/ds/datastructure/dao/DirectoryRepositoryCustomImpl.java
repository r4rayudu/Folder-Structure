package com.ds.datastructure.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.ds.datastructure.model.Directory;

public class DirectoryRepositoryCustomImpl implements DirectoryRepositoryCustom {
	@PersistenceContext
    private EntityManager entityManager;
	
	private final static String slash = "\\";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<String> getFilePathResult(String findInput) {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();
		Session session = (Session) entityManager.unwrap(Session.class);
		List<Object[]> result = session.createNativeQuery(""+
				"SELECT r.root_name, d.dir_name, f.file_name, d.sub_dir_id, d.sub_dir_name \r\n" + 
				"FROM directory d  LEFT JOIN file f ON (d.dir_id = f.dir_id) LEFT JOIN root r ON (r.root_id = d.root_id)"+
				"WHERE d.dir_name LIKE :dirName").setParameter("dirName", "%"+findInput+"%").list();
		List<String> pathlist = new ArrayList<String>();
		String basePath = new String();
		for (Object[] objects : result) {
			Long subDirId = 0L;
			if(!Objects.isNull(objects[3]))
				subDirId = ((BigInteger) objects[3]).longValue();
			StringBuffer path = new StringBuffer();
			basePath = new String();
			if(!Objects.isNull(objects[0])) {
				path.append((String)objects[0]);
				String subDirName = getSubdirName(session,subDirId, (String)objects[4]);
				if(!Objects.isNull(subDirName)) {
					path.append(subDirName).append(DirectoryRepositoryCustomImpl.slash);
				}
				if(!Objects.isNull((String)objects[1])) {
					path.append((String)objects[1]).append(DirectoryRepositoryCustomImpl.slash);
					basePath = path.toString();
				}
				if(!Objects.isNull((String)objects[2])) {
					path.append((String)objects[2]);
				}
			}
			pathlist.add(path.toString());
         }
		if(pathlist.size() > 1)
			pathlist.add(basePath);
		return pathlist;
	}
		
	private String getSubdirName(Session session, Long subDirId, String name) {
		if(subDirId == 0) {
			return name;
		}
		else {
			Directory pathDTO = session.get(Directory.class, subDirId);
			if(!Objects.isNull(pathDTO.getSubDirId())) {
				name = pathDTO.getSubDirName()+DirectoryRepositoryCustomImpl.slash+name;
				getSubdirName(session, pathDTO.getSubDirId(), name);
			}
			return name;
		}
	}
}
