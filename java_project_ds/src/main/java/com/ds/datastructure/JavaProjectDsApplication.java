package com.ds.datastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ds.datastructure.service.FileStructureService;

@SpringBootApplication
public class JavaProjectDsApplication  extends SpringBootServletInitializer implements CommandLineRunner{
	private static final Logger LOG = LoggerFactory.getLogger(JavaProjectDsApplication.class);
	
	@Autowired
	private FileStructureService fileStructureService;

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectDsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileStructureService.saveDatafromTextFile();
	}

}
