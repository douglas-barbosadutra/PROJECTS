package com.managementtool.contrader.projects.service;


import com.managementtool.contrader.projects.domain.Project;

import com.managementtool.contrader.projects.dto.NewProjectDTO;




import java.util.List;


/**
 * Service Interface for managing Project.
 */
public interface ProjectService {

    /**
     * Save a project.
     *
     * @param project the entity to save
     * @return the persisted entity
     */
  NewProjectDTO save(NewProjectDTO NewprojectDTO);

    /**
     * Get all the projects.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
  List<NewProjectDTO> findAll();


    /**
     * Get the "id" project.
     *
     * @param id the id of the entity
     * @return the entity
     */
  NewProjectDTO findOne(int id);

    /**
     * Delete the "id" project.
     *
     * @param id the id of the entity
     */
    void delete(int id);
    
    Project delete2(int id);
}
