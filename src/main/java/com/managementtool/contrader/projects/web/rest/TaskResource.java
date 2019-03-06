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

import com.managementtool.contrader.projects.domain.Project;
import com.managementtool.contrader.projects.domain.Task;
import com.managementtool.contrader.projects.dto.TaskDTO;

import com.managementtool.contrader.projects.web.rest.util.PaginationUtil;

import com.managementtool.contrader.projects.service.TaskService;


/**
/* REST controller for managing Task.
*/
 @RestController
 @RequestMapping("/Task")
 public class TaskResource {
	
	 private TaskService taskService;


		@Autowired
		public TaskResource (TaskService taskService) {
			this.taskService =  taskService;
		}
		
		@CrossOrigin
		@RequestMapping(value = "/ShowTask", method = RequestMethod.GET)
		public List<TaskDTO> getAll(){
			List<TaskDTO> task = taskService.getAll();
			return task;
		}
		
		 @CrossOrigin
			@RequestMapping(value="/deleteTask", method = RequestMethod.GET)
			public boolean delete(@RequestParam(value="id") Long id) {
				taskService.delete(id);
				return true;
	}
	
		 @RequestMapping(value = "/saveTask", method = RequestMethod.POST)
			@CrossOrigin
			public  TaskDTO  newtask(
			    @RequestParam(value="description") String description,
				@RequestParam(value="currentTask") Project project) {
				
				TaskDTO taskDTO = new TaskDTO();
				taskDTO.setDescription(description);
				taskDTO.setProject(project);
				taskDTO = taskService.save(taskDTO);
				return taskDTO;
			}
	
		 @CrossOrigin
		 @RequestMapping (value ="/updateTask", method= RequestMethod.POST)
		 public TaskDTO update (
				 @RequestParam(value = "id") Long id,
				 @RequestParam(value="description") String description,
				 @RequestParam(value="currentTask") Project project ) {
			 TaskDTO taskDTO = taskService.findOne(id);
			 taskDTO.setProject(project);
			 taskService.save(taskDTO);
			return taskDTO ; 
		 }
	
}