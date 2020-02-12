package com.ds.datastructure.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.datastructure.dao.DirectoryRepository;
import com.ds.datastructure.dao.FileRepository;
import com.ds.datastructure.dao.RootRepository;
import com.ds.datastructure.model.Directory;
import com.ds.datastructure.model.Filelists;
import com.ds.datastructure.model.Root;

@Service
public class FileStructureServiceImpl implements FileStructureService {

	private static final Logger LOG = LoggerFactory.getLogger(FileStructureServiceImpl.class);
	
	@Autowired
	private RootRepository rootRepository;

	@Autowired
	private DirectoryRepository directoryRepository;

	@Autowired
	private FileRepository fileRepository;
		
	@Override
	public List<String> getFilePathResult(String findInput) {
		return directoryRepository.getFilePathResult(findInput);
	}

	@SuppressWarnings("resource")
	@Override
	public void saveDatafromTextFile() {
		try {
		File fileObj = new File("testfile.txt");
		Scanner scannerReader = new Scanner(fileObj);
		Root saveRoot = new Root();
		Directory saveDir = new Directory();
		Long saveDirId = 0L;
		String saveDirName = null;
		Long preId = 0L;
		while (scannerReader.hasNextLine()) {
			String data = scannerReader.nextLine();
			if (ltrim(data) == 0) {
				Root root = new Root(data.trim());
				saveRoot = rootRepository.save(root);
			} else {
				String extension = getExtension(data);

				if (extension == null) {
					if (ltrim(data) == 1) {
						Directory directory = new Directory(data.trim(), saveRoot);
						saveDir = directoryRepository.save(directory);
						saveDirId = saveDir.getId();
						saveDirName = saveDir.getDirname();
					} else {
						if (ltrim(data) == preId) {
							Directory directory = new Directory(data.trim(), saveDirId, saveDirName, saveRoot);
							saveDir = directoryRepository.save(directory);
						} else {
							Directory directory = new Directory(data.trim(), saveDir.getId(), saveDir.getDirname(),
									saveRoot);
							saveDir = directoryRepository.save(directory);
						}
					}
					preId = ltrim(data);
				} else {
					Filelists file = new Filelists(data.trim(), saveDir);
					fileRepository.save(file);
				}
			}
		}
		LOG.info("Saved file structure data into database");
		} catch (FileNotFoundException e) {
			LOG.error("File not found exception"+e);
			e.printStackTrace();
		}catch (Exception e) {
			LOG.error("File structure data not saved into database "+e);
			e.printStackTrace();
		}
	}
	
	public static Long ltrim(String s) {
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return (long) i;
	}

    public static String getExtension(String str) {
		int begin = str.lastIndexOf(".");
		if (begin == -1)
			return null;
		String extension = str.substring(begin + 1);
		return extension;
	}
}
