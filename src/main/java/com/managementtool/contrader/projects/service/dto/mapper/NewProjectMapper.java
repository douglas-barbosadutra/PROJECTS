package com.managementtool.contrader.projects.service.dto.mapper;


import com.managementtool.contrader.projects.domain.Project;
import com.managementtool.contrader.projects.dto.NewProjectDTO;



public class NewProjectMapper {
	static public Project convertToProject(NewProjectDTO p) {
		Project project = new Project();
		project.setId(p.getId());
		project.setName(p.getName());
		project.setDescription(p.getDescription());
		project.setTasks(p.getTasks());
		project.setAddedValue(p.getAddedValue());
		project.setEndDate(p.getEndDate());
		project.setHeadPerson(p.getHeadPerson());
		project.setLink(p.getLink());
		project.setNextCriticalDate(p.getNextCriticalDate());
		project.setProgram(p.getProgram());
		project.setFile(p.getFile());
		project.setStatus(p.getStatus());
		return project;
	}
	
	static public NewProjectDTO convertToDto(Project p) {
		NewProjectDTO newprojectDTO = new NewProjectDTO();
		newprojectDTO.setId(p.getId());
		newprojectDTO.setName(p.getName());
		newprojectDTO.description(p.getDescription());
		newprojectDTO.tasks(p.getTasks());
		newprojectDTO.addedValue(p.getAddedValue());
		newprojectDTO.endDate(p.getEndDate());
		newprojectDTO.headPerson(p.getHeadPerson());
		newprojectDTO.link(p.getLink());
		newprojectDTO.nextCriticalDate(p.getNextCriticalDate());
		newprojectDTO.program(p.getProgram());
		newprojectDTO.file(p.getFile());
		newprojectDTO.status(p.getStatus());
		return newprojectDTO;
	}
}