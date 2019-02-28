package com.managementtool.contrader.projects.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.dto.NewFileDTO;
import com.managementtool.contrader.projects.dto.NewProgramDTO;
//import com.managementtool.contrader.projects.domain.Project;
import com.managementtool.contrader.projects.web.rest.util.PaginationUtil;
import com.managementtool.contrader.projects.service.FileService;
//import com.managementtool.contrader.projects.service.ProjectService;
import com.managementtool.contrader.projects.service.ProgramService;

/**
/* REST controller for managing File.
*/
 @RestController
 @RequestMapping("/api")
 public class FileResource {
	
	 private FileService fileService;


		@Autowired
		public FileResource (FileService fileService) {
			this.fileService =  fileService;
		}
		
		@CrossOrigin
		@RequestMapping(value = "/ShowFile", method = RequestMethod.GET)
		public List<NewFileDTO> getAll(){
			List<NewFileDTO> file = fileService.getAll();
			return file;
		}
	
	
	
	
	
}