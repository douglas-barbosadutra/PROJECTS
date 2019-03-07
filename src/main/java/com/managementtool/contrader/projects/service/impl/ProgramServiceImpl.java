package com.managementtool.contrader.projects.service.impl;

import com.managementtool.contrader.projects.service.ProgramService;
import com.managementtool.contrader.projects.service.dto.mapper.NewProgramMapper;
import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.dto.NewProgramDTO;
import com.managementtool.contrader.projects.repository.ProgramRepository;
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
 * Service Implementation for managing Program.
 */
@Service

public class ProgramServiceImpl implements ProgramService {

    private final Logger log = LoggerFactory.getLogger(ProgramServiceImpl.class);

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    /**
     * Save a program.
     *
     * @param program the entity to save
     * @return the persisted entity
     */
    @Override
    public NewProgramDTO save(NewProgramDTO newprogramDTO) {
        log.debug("Request to save Program : {}", newprogramDTO);    
       Program program = NewProgramMapper.toProgram(newprogramDTO);
        this.programRepository.save(program);
        return NewProgramMapper.toDto(programRepository.save(program));
    }

    
    /**
     * Get all the program.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<NewProgramDTO> findAll(){
		List<Program> listaProgrammi = (List<Program>) programRepository.findAll();
		List<NewProgramDTO> listaProgram = new ArrayList<>();
		listaProgrammi.forEach(i->listaProgram.add(NewProgramMapper.toDto(i)));
		return listaProgram;
	}
    


    /**
     * Get one program by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public NewProgramDTO findOne(int id) {
        log.debug("Request to get Program : {}", id);
        NewProgramDTO newprogramDTO= NewProgramMapper.toDto(programRepository.findOne(id));
        return newprogramDTO;
    }
    
   

    /**
     * Delete the program by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete (int id) {
    	log.debug("Request to delete Program : {}", id);
    	Program program = programRepository.findOne(id);
    	this.programRepository.delete(program);   	 
    }

	@Override
	public Program delete2(int id) {
		Program deleted =programRepository.findOne(id);
		programRepository.delete(deleted);
		return deleted;
		
	}

	
}
