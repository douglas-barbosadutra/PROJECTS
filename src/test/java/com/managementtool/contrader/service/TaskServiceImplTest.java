package com.managementtool.contrader.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Task;
import com.managementtool.contrader.projects.dto.PersonDTO;
import com.managementtool.contrader.projects.dto.TaskDTO;
import com.managementtool.contrader.projects.repository.PersonRepository;
import com.managementtool.contrader.projects.repository.TaskRepository;
import com.managementtool.contrader.projects.service.dto.mapper.PersonMapper;
import com.managementtool.contrader.projects.service.dto.mapper.TaskMapper;
import com.managementtool.contrader.projects.service.impl.PersonServiceImpl;
import com.managementtool.contrader.projects.service.impl.TaskServiceImpl;

public class TaskServiceImplTest {
	 @InjectMocks
	  TaskServiceImpl taskServiceImpl;

	 @Mock
	TaskRepository taskRepository;
	 @Mock
	 TaskMapper taskMapper;
	
	 
	 @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	 @Test   
	 public void findAllTest() {
		 List<Task> listaTask = new ArrayList<Task>();
		 Task task1 = new Task(1, "ciao", null);
		 Task task2 = new Task(2, "by", null);
		 Task task3 = new Task(3, "hello", null);
		 listaTask.add(task1);
		 listaTask.add(task2);
		 listaTask.add(task3);
		 when(taskRepository.findAll()).thenReturn(listaTask);
		 List<TaskDTO> task = taskServiceImpl.getAll();
		 assertEquals(3, task.size());
		 verify(taskRepository).findAll();
	 }
	
	@Test   
	public void saveTest() {
		TaskDTO taskDTO = new TaskDTO(1,"ciao",null);
		when(taskRepository.save(taskMapper.toTask(taskDTO))).thenReturn(taskMapper.toTask(taskDTO));
		assertThat(taskServiceImpl.save(taskDTO), is (notNullValue()));

	} 
	@Test
 public void findOneTest()
   {
   when(taskRepository.findOne(1)).thenReturn(new Task(1,"ciao",null));
     
     Task returned = taskMapper.toTask(taskServiceImpl.findOne(1));
     assertEquals("ciao", returned.getDescription());
     assertEquals(null, returned.getProject());
   } 
	@Test
	public void deleteTest() {
		Task deleted = new Task(1,"ciao",null);
		 when(taskRepository.findOne(1)).thenReturn(deleted);
		Task returned = taskServiceImpl.delete2(1);
		assertEquals(deleted, returned);
	} 

}
