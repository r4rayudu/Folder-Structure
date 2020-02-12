package com.ds.datastructure.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ds.datastructure.model.Filelists;

@Repository
public interface FileRepository extends JpaRepository<Filelists, Long>{
	List<Filelists> findByFilename(String filename);
}
