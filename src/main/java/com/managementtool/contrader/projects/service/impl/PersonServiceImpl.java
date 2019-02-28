package com.managementtool.contrader.projects.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.repository.PersonRepository;
import com.managementtool.contrader.projects.service.PersonService;
import com.managementtool.contrader.projects.service.dto.PersonDTO;
import com.managementtool.contrader.projects.service.dto.mapper.PersonMapper;



@Service

public class PersonServiceImpl implements PersonService{

	private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
	@Override
	public PersonDTO save(PersonDTO personDTO) {
		log.debug("Request to save Person : {}", personDTO);    
		Person person = PersonMapper.convertToPerson(personDTO);
		 this.personRepository.save(person);
		 return PersonMapper.convertToDto(personRepository.save(person));
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<PersonDTO> findAll() {
		List<Person> listaPerson = (List<Person>) personRepository.findAll();
		List<PersonDTO> PersonPerPerson= new ArrayList<>();
		listaPerson.forEach(i->PersonPerPerson.add(PersonMapper.convertToDto(i)));
		return PersonPerPerson;
	}

	/*public PatologiaDTO findById(long idpatologia) {
		PatologiaDTO patologiaDTO = PatologiaConverter.convertToDto(patologiaDAO.findById(idpatologia).get());
		return patologiaDTO;
	} */
	@Override
	 @Transactional(readOnly = true)
	public PersonDTO findOne(Long id) {
	//	log.debug("Request to get Person : {}", id);
		PersonDTO personDTO = PersonMapper.convertToDto(personRepository.findById(id).get());
        return  personDTO;
        
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Person : {}", id);
        personRepository.deleteById(id);
		
	}

}
