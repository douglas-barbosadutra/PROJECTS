package com.managementtool.contrader.mapper;

import com.managementtool.contrader.domain.Person;
import com.managementtool.contrader.dto.PersonDTO;

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