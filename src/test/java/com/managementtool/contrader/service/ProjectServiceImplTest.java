package com.managementtool.contrader.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.domain.Project;
import com.managementtool.contrader.projects.domain.Task;
import com.managementtool.contrader.projects.dto.NewProjectDTO;
import com.managementtool.contrader.projects.repository.ProjectRepository;

import com.managementtool.contrader.projects.service.dto.mapper.NewProjectMapper;
import com.managementtool.contrader.projects.service.impl.ProjectServiceImpl;

public class ProjectServiceImplTest {
 	@InjectMocks
    ProjectServiceImpl projectServiceImpl;
	

	  @Mock
	  ProjectRepository projectRepository;
	  
	  @Mock
	  NewProjectMapper newprojectMapper;
	  
	  @Before
	  public void init() {
	        MockitoAnnotations.initMocks(this);
	  }
	  
	  @Test
	    public void  findAll(){
		  
		  List<Project> listaProgetto = new ArrayList<Project>();

		  ZonedDateTime data=ZonedDateTime.now();
		  Task t = new Task();
		  File f = new File();
		  Program p = new Program();
		  Person e = new Person();
		  Set<Task> s = new HashSet<>();
		  
		  Project project1 =new Project(1,"Sara",1 ,"Ciao",  "Ciao", "Ciao", data, data, f, p, e ,t, s);
		     
		  Project project2 =new Project(2,  "Carla", 2, "Ciao", "ciao", "anto", data, data, f, p, e ,t, s);
		  Project project3 =new Project(3,  "Ale", 3,"Ciao", "ciao", "dopo", data, data, f, p, e ,t, s);
		
		  
		  listaProgetto.add(project1);
		  listaProgetto.add(project2);
		  listaProgetto.add(project3);
		  when (projectRepository.findAll()).thenReturn(listaProgetto);
		  List<NewProjectDTO> programmi = projectServiceImpl.findAll();
		  assertEquals(3, programmi.size());
	        verify(projectRepository, times(1)).findAll();
		  
	    }
	  

	     @Test
	        public void save() {
	    	 
	    	 ZonedDateTime data=ZonedDateTime.now();
	    
			  File f = new File();
			  Program p = new Program();
			  Person e = new Person();
			  Set<Task> s = new HashSet<>();
	    	 
	          NewProjectDTO newprojectDTO = new NewProjectDTO(4, "Bye", 1 ,"Ciao",  "Ciao", "Ciao", data, data, f, p, e , s);
	          when(projectRepository.save(NewProjectMapper.convertToProject(newprojectDTO))).thenReturn(NewProjectMapper.convertToProject(newprojectDTO));
	          assertThat(projectServiceImpl.save(newprojectDTO), is(notNullValue()));
	        	     }
	  
	    @Test
	     public void findOne(){
	    	
	    	ZonedDateTime data=ZonedDateTime.now();
	    	  Task t = new Task();
			  File f = new File();
			  Program p = new Program();
			  Person e = new Person();
			  Set<Task> s = new HashSet<>();
	    	
	    	
	    	 when(projectRepository.findOne(1)).thenReturn(new Project (1, "Sara", 1 , "Sara","Sara", "Sara", data, data, f, p, e ,t, s));
	          
	          Project project = NewProjectMapper.convertToProject(projectServiceImpl.findOne(1));
	        
	          assertEquals("Sara", project.getName());
	          assertEquals("Sara", project.getStatus());
	          assertEquals("Sara", project.getDescription());
	          assertEquals(data, project.getEndDate());
	          assertEquals("Sara", project.getLink());
	          assertEquals(data, project.getNextCriticalDate());
	          assertEquals(f, project.getFile());
	          assertEquals(p, project.getProgram());
	          assertEquals(e, project.getHeadPerson());
	          assertEquals(s, project.getTasks());
	        
	          
	    }
	    
	    @Test
	      public void delete() {

	    	ZonedDateTime data=ZonedDateTime.now();
	    	Task t = new Task();
	    	File f = new File();
	    	Program p = new Program();
	    	Person e = new Person();
	    	Set<Task> s = new HashSet<>();
	    	
	    	
		    	Project deleted = new Project(1, "Sara",  1, "Sara","Sara", "Sara", data, data, f, p, e ,t, s);
				 when(projectRepository.findOne(1)).thenReturn(deleted);
				Project returned = projectServiceImpl.delete2(1);
				assertEquals(deleted, returned);
		    	
		   }    	  
}
