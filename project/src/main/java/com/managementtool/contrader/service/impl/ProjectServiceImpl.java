package com.managementtool.contrader.service.impl;


import com.managementtool.contrader.mapper.NewProjectMapper;

import com.managementtool.contrader.domain.Project;
import com.managementtool.contrader.dto.NewProjectDTO;
import com.managementtool.contrader.repository.ProjectRepository;
import com.managementtool.contrader.service.ProjectService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Service Implementation for managing Project.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository; }

    /**
     * Save a project.
     *
     * @param project the entity to save
     * @return the persisted entity
     */
  @Override
    public NewProjectDTO save(NewProjectDTO NewProjectDTO) {
	  Project project = NewProjectMapper.convertToProject(NewProjectDTO);
		 this.projectRepository.save(project);
		 return NewProjectMapper.convertToDto(projectRepository.save(project));
	}

   @Override
    @Transactional(readOnly = true)

  public List<NewProjectDTO> findAll() {
	   List<Project> listaProject = (List<Project>) projectRepository.findAll();
		List<NewProjectDTO> ProjectPerProject= new ArrayList<>();
		listaProject.forEach(i->ProjectPerProject.add(NewProjectMapper.convertToDto(i)));
		return ProjectPerProject;
    }

   @Override
    @Transactional(readOnly = true)
    public  NewProjectDTO findOne(int id) {
	   NewProjectDTO projectDTO = NewProjectMapper.convertToDto(projectRepository.findOne(id));
       return  projectDTO;
    }

    @Override
    public void delete(int id) {
       // log.debug("Request to delete Project : {}", id);
    	Project project = projectRepository.findOne(id);
    	this.projectRepository.delete(project);   
       
    }
    @Override
	public Project delete2(int id) {
		Project deleted =projectRepository.findOne(id);
		projectRepository.delete(deleted);
		return deleted;
    }
}
