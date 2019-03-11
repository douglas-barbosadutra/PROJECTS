package com.managementtool.contrader.service;
import com.managementtool.contrader.dto.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.managementtool.contrader.domain.Person;
import com.managementtool.contrader.domain.Project;


public interface PersonService {
	/**
     * Save a project.
     *
     * @param project the entity to save
     * @return the persisted entity
     */
	PersonDTO save(PersonDTO personDTO);

    /**
     * Get all the projects.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    List<PersonDTO> findAll();


    /**
     * Get the "id" project.
     *
     * @param id the id of the entity
     * @return the entity
     */

    /**
     * Delete the "id" project.
     *
     * @param id the id of the entity
     */
    void delete(int id);

	PersonDTO findOne(int id);
	
	 Person delete2(int id);
}


