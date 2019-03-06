package com.managementtool.contrader.service;


import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.dto.NewProgramDTO;
import com.managementtool.contrader.projects.repository.ProgramRepository;
import com.managementtool.contrader.projects.service.ProgramService;
import com.managementtool.contrader.projects.service.dto.mapper.NewProgramMapper;
import com.managementtool.contrader.projects.service.impl.ProgramServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
 



public class ProgramServiceImplTest {
	
   	@InjectMocks
      ProgramServiceImpl programServiceImpl;
	

	  @Mock
	  ProgramRepository programRepository;
	  
	  @Mock
	  NewProgramMapper newprogramMapper;
	  
	  
	  @Before
	  public void init() {
	        MockitoAnnotations.initMocks(this);
	  }
	  
	  @Test
	    public void  findAll(){
		  
		  List<Program> listaProgrammi = new ArrayList<Program>();
		  Program program1 =new Program(1, "Sara");
		  Program program2 =new Program(2, "Ale");
		  Program program3 =new Program(3, "Mario");
		
		  
		  listaProgrammi.add(program1);
		  listaProgrammi.add(program2);
		  listaProgrammi.add(program3);
		  when (programRepository.findAll()).thenReturn(listaProgrammi);
		  List<NewProgramDTO> programmi = programServiceImpl.findAll();
		  assertEquals(3, programmi.size());
	        verify(programRepository, times(1)).findAll();
		  
	    }
	  
	
	     @Test
	        public void save() {
	          NewProgramDTO program = new NewProgramDTO(4, "Bye");
	          when(programRepository.save(NewProgramMapper.toProgram(program))).thenReturn(new Program());
	          assertThat(programServiceImpl.save(program), is(notNullValue()));
	        // verify(programRepository).save(NewProgramMapper.toProgram(program));
	     }
}