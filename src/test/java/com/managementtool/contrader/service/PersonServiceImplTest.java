

package com.managementtool.contrader.service;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.dto.PersonDTO;
import com.managementtool.contrader.projects.repository.PersonRepository;
import com.managementtool.contrader.projects.service.dto.mapper.PersonMapper;
import com.managementtool.contrader.projects.service.impl.PersonServiceImpl;

	public class PersonServiceImplTest {
		
		 @InjectMocks
		  PersonServiceImpl personServiceImpl;

		 @Mock
		PersonRepository personRepository;
		 @Mock
		 PersonMapper personMapper;
		
		 
		 @Before
		    public void init() {
		        MockitoAnnotations.initMocks(this);
		    }
		 
		 @Test   
		 public void findAllTest() {
			 List<Person> listaPersone = new ArrayList<Person>();
			 Person persona1 = new Person(1, "Alessandra", "Russo");
			 Person persona2 = new Person(2, "Sara", "Cardaci");
			 Person persona3 = new Person(3, "Mario", "LaMonaca");
			 listaPersone.add(persona1);
			 listaPersone.add(persona2);
			 listaPersone.add(persona3);
			 when(personRepository.findAll()).thenReturn(listaPersone);
			 List<PersonDTO> persone = personServiceImpl.findAll();
			 assertEquals(3, persone.size());
			 verify(personRepository).findAll();
		 }
		
		@Test   
		public void saveTest() {
			PersonDTO personDTO = new PersonDTO(1,"ciao","Ciao");
			when(personRepository.save(personMapper.convertToPerson(personDTO))).thenReturn(personMapper.convertToPerson(personDTO));
			assertThat(personServiceImpl.save(personDTO), is (notNullValue()));

		}
		@Test
	  public void findOneTest()
	    {
	    when(personRepository.findOne(1)).thenReturn(new Person(1,"ciao","Ciao"));
	      
	      Person returned = PersonMapper.convertToPerson(personServiceImpl.findOne(1));
	      assertEquals("ciao", returned.getName());
	      assertEquals("Ciao", returned.getLastName());
	    } 
		@Test
		public void deleteTest() {
			Person deleted = new Person(1,"ciao","Ciao");
			when(personRepository.findOne(1)).thenReturn(deleted);
			Person returned = personServiceImpl.delete2(1);
			assertEquals(deleted, returned);
		} 

		

	}


