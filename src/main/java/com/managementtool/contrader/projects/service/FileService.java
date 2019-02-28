package com.managementtool.contrader.projects.service;

import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.dto.NewFileDTO;
import com.managementtool.contrader.projects.dto.NewProgramDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Program.
 */
public interface FileService {

    /**
     * Save a file.
     *
     * @param program the entity to save
     * @return the persisted entity
     */
    File save(File file);

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
    Optional<File> findOne(Long id);

    /**
     * Delete the "id" file.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
