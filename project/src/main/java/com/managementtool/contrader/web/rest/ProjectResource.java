package com.managementtool.contrader.web.rest;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managementtool.contrader.service.ProjectService;
import com.managementtool.contrader.domain.File;
import com.managementtool.contrader.domain.Person;
import com.managementtool.contrader.domain.Program;
import com.managementtool.contrader.dto.NewProjectDTO;
import com.managementtool.contrader.dto.PersonDTO;



@RestController
@CrossOrigin
@RequestMapping("/ProjectResource")
public class ProjectResource {
	private ProjectService projectService;
	
	@Autowired
	public ProjectResource(ProjectService projectService) {
		this.projectService = projectService;
	}
	@CrossOrigin
	@RequestMapping(value = "/ShowProject", method = RequestMethod.GET)
	public List<NewProjectDTO> getAll(){
		List<NewProjectDTO> project = projectService.findAll();
		return project;
	}
	 @CrossOrigin
		@RequestMapping(value="/delete", method = RequestMethod.GET)
		public boolean delete(@RequestParam(value="id") int id) {
			projectService.delete(id);
			return true;
			
		}
	 @RequestMapping(value = "/Insert", method = RequestMethod.POST)
		@CrossOrigin
		public NewProjectDTO newProject(
				@RequestParam(value="name") String name,
				@RequestParam(value="link") String link,
				@RequestParam(value="description") String description,
				@RequestParam(value="addedValue") Float addedValue,
				@RequestParam(value="endDate") ZonedDateTime endDate,
				@RequestParam(value="nextCriticalDate") ZonedDateTime nextCriticalDate,
				@RequestParam(value="status") String status	)
	 {
		 NewProjectDTO newProjectDTO = new  NewProjectDTO();
		 newProjectDTO.setName(name);
		 newProjectDTO.setLink(link);
		 newProjectDTO.setDescription(description);
		 newProjectDTO.setAddedValue(addedValue);
		 newProjectDTO.setEndDate(endDate);
		 newProjectDTO.setNextCriticalDate(nextCriticalDate);
		 newProjectDTO.setStatus(status);
		 newProjectDTO = projectService.save(newProjectDTO);
			return newProjectDTO;
		}
	 
	 @CrossOrigin
		@RequestMapping(value="/update", method = RequestMethod.POST)
	 public NewProjectDTO update(
			 @RequestParam(value= "id") int id,
			 @RequestParam(value="name") String name,
				@RequestParam(value="link") String link,
				@RequestParam(value="description") String description,
				@RequestParam(value="addedValue") Float addedValue,
				@RequestParam(value="endDate") ZonedDateTime endDate,
				@RequestParam(value="nextCriticalDate") ZonedDateTime nextCriticalDate,
				@RequestParam(value="status") String status)
			 	 {
		 NewProjectDTO projectDTO = projectService.findOne(id);
		 projectDTO.setName(name);
		 projectDTO.setLink(link);
		 projectDTO.setDescription(description);
		 projectDTO.setAddedValue(addedValue);
		 projectDTO.setEndDate(endDate);
		 projectDTO.setNextCriticalDate(nextCriticalDate);
		 projectDTO.setStatus(status);
		 projectService.save(projectDTO);
		return projectDTO;
	 }
}

