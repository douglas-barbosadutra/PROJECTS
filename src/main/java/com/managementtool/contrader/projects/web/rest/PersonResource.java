package com.managementtool.contrader.projects.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managementtool.contrader.projects.service.PersonService;
import com.managementtool.contrader.projects.dto.PersonDTO;



@RestController
@CrossOrigin
@RequestMapping("/PersonResource")
public class PersonResource {
	private PersonService personService;
	
	@Autowired
	public PersonResource(PersonService personService) {
		this.personService = personService;
	}
	@CrossOrigin
	@RequestMapping(value = "/ShowPerson", method = RequestMethod.GET)
	public List<PersonDTO> getAll(){
		List<PersonDTO> person = personService.findAll();
		return person;
	}
	 @CrossOrigin
		@RequestMapping(value="/delete", method = RequestMethod.GET)
		public boolean delete(@RequestParam(value="id") int id) {
		personService.delete(id);
			return true;
			
		}
	 @RequestMapping(value = "/Insert", method = RequestMethod.POST)
		@CrossOrigin
		public PersonDTO newPerson(
				@RequestParam(value="name") String name,
				@RequestParam(value="lastName") String lastName) {
		 PersonDTO personDTO = new  PersonDTO();
		 personDTO.setName(name);
		 personDTO.setLastName(lastName);
		 personDTO = personService.save(personDTO);
			return personDTO;
		}
	 
	 @CrossOrigin
		@RequestMapping(value="/update", method = RequestMethod.POST)
	 public PersonDTO update(
			 @RequestParam(value= "id") int id,
			 	@RequestParam(value= "name") String name,
			 	@RequestParam(value= "lastName") String lastName) {
		 PersonDTO personDTO = personService.findOne(id);
		 personDTO.setName(name);
		 personDTO.setLastName(lastName);
		 personService.save(personDTO);
		return personDTO;
	 }
}
