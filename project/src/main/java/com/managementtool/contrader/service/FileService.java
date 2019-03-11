package com.managementtool.contrader.service;

import com.managementtool.contrader.domain.File;
import com.managementtool.contrader.dto.NewFileDTO;
import com.managementtool.contrader.dto.NewProgramDTO;
import com.managementtool.contrader.dto.PersonDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing File.
 */
public interface FileService {

    /**
     * Save a file.
     *
     * @param file the entity to save
     * @return the persisted entity
     */
    NewFileDTO save(NewFileDTO newfileDTO);

    /**
     * Get all the file.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    List<NewFileDTO> getAll();


    /**
     * Get the "id" file.
     *
     * @param id the id of the entity
     * @return the entity
     */
    NewFileDTO findOne(Long id);

    /**
     * Delete the "id" file.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    /**
     * Get the "id" file.
     *
     * @param id the id of the entity
     * @return the entity
     */
    NewFileDTO findOneTest(int id);
    
    /**
     * Get the "id" file.
     *
     * @param id the id of the entity
     * @return the entity
     */
    File deleteTest (int id);
}
