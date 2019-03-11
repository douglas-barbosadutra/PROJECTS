package com.managementtool.contrader.mapper;

import com.managementtool.contrader.domain.File;

import com.managementtool.contrader.dto.NewFileDTO;



public class NewFileMapper {
	static public File toFile(NewFileDTO f) {
		File file = new File();
		file.setId(f.getId());
		file.setName(f.getName());
		file.setUrl(f.getUrl());
		file.setSize(f.getSize());
		file.setMime(f.getMime());
			
				
		return file;
	}
	
	static public NewFileDTO toDto(File f) {
		NewFileDTO newfileDTO = new NewFileDTO();
		newfileDTO.setId(f.getId());
		newfileDTO.setName(f.getName());
		newfileDTO.setUrl(f.getUrl());
		newfileDTO.setSize(f.getSize());
		newfileDTO.setMime(f.getMime());
		
		return newfileDTO;
	}
}
