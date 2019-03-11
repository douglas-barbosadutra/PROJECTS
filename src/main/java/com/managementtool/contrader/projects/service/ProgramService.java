package com.managementtool.contrader.projects.service;

import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.dto.NewProgramDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Program.
 */
public interface ProgramService {

    /**
     * Save a program.
     *
     * @param program the entity to save
     * @return the persisted entity
     */
    NewProgramDTO save(NewProgramDTO newprogramDTO);

    /**
     * Get all the program.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    List<NewProgramDTO> findAll();


    /**
     * Get the "id" program.
     *
     * @param id the id of the entity
     * @return the entity
     */
    NewProgramDTO findOne(int id);
    /**
     * Delete the "id" program.
     *
     * @param id the id of the entity
     */
    void delete(int id);
    
   
    
    Program delete2(int id);

	
	
}
