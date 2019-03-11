package com.managementtool.contrader.mapper;

import com.managementtool.contrader.domain.Task;

import com.managementtool.contrader.dto.TaskDTO;



public class TaskMapper {
	static public Task toTask(TaskDTO t) {
		Task task = new Task();
		task.setId(t.getId());
		task.setDescription(t.getDescription());
		task.setProject(t.getProject());
			
				
		return task;
	}
	
	static public TaskDTO toDto(Task t) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setId(t.getId());
		taskDTO.setDescription(t.getDescription());
		taskDTO.setProject(t.getProject());
		
		return taskDTO;
	}
}