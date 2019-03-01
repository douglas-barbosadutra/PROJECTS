package com.managementtool.contrader.projects.service.impl;

import com.managementtool.contrader.projects.service.FileService;
import com.managementtool.contrader.projects.service.dto.mapper.NewFileMapper;
import com.managementtool.contrader.projects.service.dto.mapper.NewProgramMapper;
import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.dto.NewFileDTO;
import com.managementtool.contrader.projects.dto.NewProgramDTO;
import com.managementtool.contrader.projects.repository.FileRepository;
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
 * Service Implementation for managing File.
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {

    private final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    /**
     * Save a file.
     *
     * @param file the entity to save
     * @return the persisted entity
     */
    @Override
    public NewFileDTO save(NewFileDTO newfileDTO) {
        log.debug("Request to save File : {}", newfileDTO);    
       File file = NewFileMapper.toFile(newfileDTO);
        this.fileRepository.save(file);
        return NewFileMapper.toDto(fileRepository.save(file));
    }

    /**
     * Get all the file.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<NewFileDTO> getAll(){
		List<File> listaFile = (List<File>) fileRepository.findAll();
		List<NewFileDTO> listafile = new ArrayList<>();
		listaFile.forEach(i->listafile.add(NewFileMapper.toDto(i)));
		return listafile;
	}

    /**
     * Get one file by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public NewFileDTO findOne(Long id) {
        log.debug("Request to get File : {}", id);
        NewFileDTO newfileDTO= NewFileMapper.toDto(fileRepository.findById(id).get());
        return newfileDTO;
    }
    /**
     * Delete the program by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete (Long id) {
    	log.debug("Request to delete File : {}", id);
    	File file = fileRepository.findById(id).get();
    	this.fileRepository.delete(file);   	 
    }
}
