package com.ds.datastructure.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.ds.datastructure.service.FileStructureService;

@SpringBootTest
@AutoConfigureMockMvc
public class FileStructureControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	FileStructureService fileStructureService;
	
	@Test
	@DisplayName("Path searching page test")
	public void getFilePathTest() throws Exception{
		this.mockMvc.perform(get("/findPathPage"))
					.andExpect(status().isOk())
					.andExpect(view().name("search"));
	}
	
	@Test
	@DisplayName("Path result test")
	public void getFilePathResult() throws Exception{
		List<String> pathList = new ArrayList<>();
		pathList.add("C:\\Program Files\\Mysql\\Mysql.exe");
		when(fileStructureService.getFilePathResult("image")).thenReturn(pathList);
		this.mockMvc.perform(get("/findPathResult").param("find", "image"))
		.andExpect(status().isOk())
		.andExpect(view().name("search"));
	}
}
