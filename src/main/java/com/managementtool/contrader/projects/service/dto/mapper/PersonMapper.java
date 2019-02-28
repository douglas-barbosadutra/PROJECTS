package com.managementtool.contrader.projects.service.dto.mapper;

import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.service.dto.PersonDTO;

public class PersonMapper {
	public static PersonDTO convertToDto(Person p) {
		PersonDTO person = new PersonDTO();
		person.setId(p.getId());
		person.setName(p.getName());
		person.setLastName(p.getLastName());
		return person;
	}
	public static Person convertToPerson(PersonDTO p) {
		Person person = new Person();
		person.setId(p.getId());
		person.setName(p.getName());
		person.setLastName(p.getLastName());
		return person;
	}
}