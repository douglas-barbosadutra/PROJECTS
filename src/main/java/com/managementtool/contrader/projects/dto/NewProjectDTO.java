package com.managementtool.contrader.projects.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.domain.Task;


public class NewProjectDTO implements Serializable {
	private Long id;
	private File file;
	private String name;
	private String link;
	private String description;
	private Float addedValue;
	private ZonedDateTime endDate;
	private ZonedDateTime nextCriticalDate;
	private com.managementtool.contrader.projects.domain.Program program;
	private Person headPerson;
	@JsonIgnoreProperties({"project"})
	private Set<Task> tasks;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Person getHeadPerson() {
		return headPerson;
	}

	public void setHeadPerson(Person headPerson) {
		this.headPerson = headPerson;
	}

	public NewProjectDTO headPerson(Person headPerson) {
		this.headPerson = headPerson;
		return this;
	}
	
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public NewProjectDTO program(Program program) {
		this.program = program;
		return this;
	}
	
	public ZonedDateTime getNextCriticalDate() {
		return nextCriticalDate;
	}

	public void setNextCriticalDate(ZonedDateTime nextCriticalDate) {
		this.nextCriticalDate = nextCriticalDate;
	}

	public NewProjectDTO nextCriticalDate(ZonedDateTime nextCriticalDate) {
		this.nextCriticalDate = nextCriticalDate;
		return this;
	}
	
	public ZonedDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(ZonedDateTime endDate) {
		this.endDate = endDate;
	}

	public NewProjectDTO endDate(ZonedDateTime endDate) {
		this.endDate = endDate;
		return this;
	}
	
	public Float getAddedValue() {
		return addedValue;
	}

	public void setAddedValue(Float addedValue) {
		this.addedValue = addedValue;
	}

	public NewProjectDTO addedValue(Float addedValue) {
		this.addedValue = addedValue;
		return this;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NewProjectDTO description(String description) {
		this.description = description;
		return this;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public NewProjectDTO link(String link) {
		this.link = link;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NewProjectDTO id(Long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NewProjectDTO name(String name) {
		this.name = name;
		return this;
	}
	
	public File getFile() {
		return file;
	}
	
//	public void setFile(MultipartFile file) {
	public void setFile(File file) {
		this.file = file;
	}

	public NewProjectDTO file(File file) {
		this.file = file;
		return this;
	}
	public NewProjectDTO status(String status) {
		this.status = status;
		return this;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public NewProjectDTO tasks(Set<Task> tasks) {
		this.tasks = tasks;
		return this;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewProjectDTO project = (NewProjectDTO) o;
        if (project.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", link='" + getLink() + "'" +
            ", description='" + getDescription() + "'" +
            ", addedValue=" + getAddedValue() +
            ", endDate='" + getEndDate() + "'" +
            ", nextCriticalDate='" + getNextCriticalDate() + "'" +
			", file='" + getFile().getName() + "'" +
            "}";
    }
}
