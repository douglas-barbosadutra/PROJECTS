package com.managementtool.contrader.projects.dto;



import com.managementtool.contrader.projects.domain.Program;

import java.io.Serializable;

import java.util.Objects;

public class NewProgramDTO implements Serializable {
	private Long id;
	private String name;
	
	
	 public NewProgramDTO() {

	 }
	 
	 public NewProgramDTO(long id,String name) {
			this.id = id;
			this.name = name;
			
		}
	
	public Long getId() {
        return id;
    }

 
    
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Program program = (Program) o;
        if (program.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), program.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Program{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }

}