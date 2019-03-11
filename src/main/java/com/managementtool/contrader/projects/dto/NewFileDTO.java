package com.managementtool.contrader.projects.dto;



import com.managementtool.contrader.projects.domain.File;


import java.io.Serializable;

import java.util.Objects;

public class NewFileDTO implements Serializable {
	private int id;
	private String name;
	private String url;
	private int size;
	private String mime;
	
	 public NewFileDTO() {

	 }
	 

	 public NewFileDTO(int id,String name,String url, int size, String mime) {

			this.id = id;
			this.name = name;
			this.url = url;
			this.size = size;
			this.mime = mime;
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        File file = (File) o;
	        if (file.getId() == 0 || getId() == 0) {
	            return false;
	        }
	        return Objects.equals(getId(), file.getId());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }
	    
	   @Override
	    public String toString() {
	        return "File{" +
	            "id=" + getId() +
	            ", name='" + getName() + "'" +
	            ", url='" + getUrl() + "'" +
	            ", size=" + getSize() +
	            ", mime='" + getMime() + "'" +
	            "}";
	    }
	
}