package com.managementtool.contrader.projects.dto;




import com.managementtool.contrader.projects.domain.Project;
import com.managementtool.contrader.projects.domain.Task;

import java.io.Serializable;

import java.util.Objects;

public class TaskDTO implements Serializable {
	private Long id;
	private String description;
	private Project project;
	
	 public TaskDTO() {

	 }
	 
	 public TaskDTO(long id,String description, Project project) {
			this.id = id;
			this.description = description;
			this.project = project;
		}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	  @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        Task task = (Task) o;
	        if (task.getId() == null || getId() == null) {
	            return false;
	        }
	        return Objects.equals(getId(), task.getId());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }

	    @Override
	    public String toString() {
	        return "Task{" +
	            "id=" + getId() +
	            ", description='" + getDescription() + "'" +
	            "}";
	    }
	}

	

