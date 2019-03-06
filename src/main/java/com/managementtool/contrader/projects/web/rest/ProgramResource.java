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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.dto.NewProgramDTO;
//import com.managementtool.contrader.projects.domain.Project;
import com.managementtool.contrader.projects.web.rest.util.PaginationUtil;

import com.managementtool.contrader.projects.service.ProgramService;
//import com.managementtool.contrader.projects.service.ProjectService;

/**
/* REST controller for managing program.
*/
 @RestController
 @RequestMapping("/Program")
 public class ProgramResource {
	
	 private ProgramService programService;


		@Autowired
		public ProgramResource (ProgramService programService) {
			this.programService =  programService;
		}
		
		@CrossOrigin
		@RequestMapping(value = "/ShowProgram", method = RequestMethod.GET)
		public List<NewProgramDTO> getAll(){
			List<NewProgramDTO> program = programService.findAll();
			return program;
		}
		
		 @CrossOrigin
			@RequestMapping(value="/delete", method = RequestMethod.GET)
			public boolean delete(@RequestParam(value="id") Long id) {
				programService.delete(id);
				return true;
	}
	
		 @RequestMapping(value = "/saveProgram", method = RequestMethod.POST)
			@CrossOrigin
			public  NewProgramDTO  newprogram(
				@RequestParam(value="name") String name) {
				
				NewProgramDTO newprogramDTO = new NewProgramDTO();
				newprogramDTO.setName(name);
				newprogramDTO = programService.save(newprogramDTO);
				return newprogramDTO;
			}
	
		 @CrossOrigin
		 @RequestMapping (value ="/update", method= RequestMethod.POST)
		 public NewProgramDTO update (
				 @RequestParam(value = "id") Long id,
				 @RequestParam(value="name") String name) {
			 NewProgramDTO newprogramDTO = programService.findOne(id);
			 newprogramDTO.setName(name);
			 programService.save(newprogramDTO);
			return newprogramDTO ; 
		 }
	
}