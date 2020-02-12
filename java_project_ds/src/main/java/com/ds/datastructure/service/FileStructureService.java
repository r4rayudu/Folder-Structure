package com.ds.datastructure.service;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public interface FileStructureService {
	List<String> getFilePathResult(String findInput);
	void saveDatafromTextFile();
}
