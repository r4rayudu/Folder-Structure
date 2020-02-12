package com.ds.datastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ds.datastructure.service.FileStructureService;

@Controller
public class FileStructureController {

	@Autowired
	FileStructureService fileStructureService;
	
	@RequestMapping(path = "/findPathPage", method = RequestMethod.GET)
	public ModelAndView getFilePath() {
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("search"); 
		 return modelAndView;
	}
	
	@RequestMapping(path = "/findPathResult", method = RequestMethod.GET)
	public ModelAndView getFilePathResult(@RequestParam("find")String findInput) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> pathList = fileStructureService.getFilePathResult(findInput);
		modelAndView.addObject("findInput", findInput);
		modelAndView.addObject("pathList", pathList);
		modelAndView.setViewName("search");
		return modelAndView;
	}
}
