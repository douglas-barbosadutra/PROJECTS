package com.managementtool.contrader.service.dto.mapper;

import com.managementtool.contrader.domain.Project;
import com.managementtool.contrader.service.dto.NewProjectDTO;

public class NewProjectMapper {
	static public Project toProject(NewProjectDTO p) {
		Project project = new Project();
		project.name(p.getName())
				.description(p.getDescription())
				.tasks(p.getTasks())
				.addedValue(p.getAddedValue())
				.endDate(p.getEndDate())
				.headPerson(p.getHeadPerson())
				.link(p.getLink())
				.nextCriticalDate(p.getNextCriticalDate())
				.program(p.getProgram());
		return project;
	}
}
