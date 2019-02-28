package com.managementtool.contrader.projects.dto;



import com.managementtool.contrader.projects.domain.File;


import java.io.Serializable;

import java.util.Objects;

public class NewFileDTO implements Serializable {
	private Long id;
	private String name;
	private String url;
	private Long size;
	private String mime;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
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
	        if (file.getId() == null || getId() == null) {
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