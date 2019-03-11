package com.managementtool.contrader.mapper;

import java.util.Optional;

import com.managementtool.contrader.domain.Program;

import com.managementtool.contrader.dto.NewProgramDTO;



public class NewProgramMapper {
	static public Program toProgram(NewProgramDTO p) {
		Program program = new Program();
		program.setId(p.getId());
		program.setName(p.getName());
			
				
		return program;
	}
	
	static public NewProgramDTO toDto(Program p) {
		NewProgramDTO newprogramDTO = new NewProgramDTO();
		newprogramDTO.setId(p.getId());
		newprogramDTO.setName(p.getName());
		
		return newprogramDTO;
	}
}
