package com.managementtool.contrader.projects.service.impl;

import com.managementtool.contrader.projects.service.TaskService;
import com.managementtool.contrader.projects.service.dto.mapper.TaskMapper;

import com.managementtool.contrader.projects.domain.Task;
import com.managementtool.contrader.projects.dto.TaskDTO;
import com.managementtool.contrader.projects.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing Task.
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final Logger log = LoggerFactory.getLogger(ProgramServiceImpl.class);

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Save a task.
     *
     * @param task the entity to save
     * @return the persisted entity
     */
    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        log.debug("Request to save Task : {}", taskDTO);    
       Task task =TaskMapper.toTask(taskDTO);
        this.taskRepository.save(task);
        return TaskMapper.toDto(taskRepository.save(task));
    }

    
    /**
     * Get all the task.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TaskDTO> getAll(){
		List<Task> listaTask = (List<Task>) taskRepository.findAll();
		List<TaskDTO> listatask = new ArrayList<>();
		listaTask.forEach(i->listatask.add(TaskMapper.toDto(i)));
		return listatask;
	}
    


    /**
     * Get one task by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TaskDTO findOne(Long id) {
        log.debug("Request to get Task : {}", id);
        TaskDTO taskDTO= TaskMapper.toDto(taskRepository.findById(id).get());
        return taskDTO;
    }
    
   

    /**
     * Delete the task by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete (Long id) {
    	log.debug("Request to delete Task : {}", id);
    	Task task = taskRepository.findById(id).get();
    	this.taskRepository.delete(task);   	 
    }
}
