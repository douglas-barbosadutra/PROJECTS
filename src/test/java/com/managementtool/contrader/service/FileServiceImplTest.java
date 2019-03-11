package com.managementtool.contrader.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Program;
import com.managementtool.contrader.projects.dto.NewFileDTO;
import com.managementtool.contrader.projects.repository.FileRepository;
import com.managementtool.contrader.projects.service.dto.mapper.NewFileMapper;
import com.managementtool.contrader.projects.service.dto.mapper.NewProgramMapper;
import com.managementtool.contrader.projects.service.dto.mapper.PersonMapper;
import com.managementtool.contrader.projects.service.impl.FileServiceImpl;

public class FileServiceImplTest {
	
	@InjectMocks
	FileServiceImpl fileServiceImpl;
     
    @Mock
    FileRepository fileRepository;
    NewFileMapper newFileMapper;
	  
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    private static final long ID =1;
     
    @Test
    public void AllListService() {
    	
    	List<File> listFile = new ArrayList<File>();
    	File _fileOne = new File(1, "John", "Ricardo",11, "crudo");
    	File _fileTwo = new File(2, "Giacomo", "Dos",13, "cotto");
    	File _fileThree = new File(3, "John", "Santos",15, "salato");
         
        listFile.add(_fileOne);
        listFile.add(_fileTwo);
        listFile.add(_fileThree);
        
        when(fileRepository.findAll()).thenReturn(listFile);
        
        //test
        List<NewFileDTO> empList = fileServiceImpl.getAll();
         
        assertEquals(3, empList.size());
        verify(fileRepository, times(1)).findAll();
    }
    
    @Test
    public void save() {
    	NewFileDTO _fileDTO = new NewFileDTO(1,"Giacomo","Dos",22,"cotto");
        
    	//fileServiceImpl.save(_fileDTO);
    	when(fileRepository.save(NewFileMapper.toFile(_fileDTO))).thenReturn(new File());
        assertThat(fileServiceImpl.save(_fileDTO), is(notNullValue()));
    	
        //verify(fileRepository, times(1)).save(_fileDTO);
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void findFirstOne()
    {
    	  when(fileRepository.findOneTest(1)).thenReturn(new File(1,"Giacomo","Dos",22, "cotto"));
	      
	      File _file = newFileMapper.toFile(fileServiceImpl.findOneTest(1));
	      assertEquals("cotto", _file.getMime());
	      assertEquals("Giacomo", _file.getName());
	      assertEquals(22, _file.getSize());
	      assertEquals("Dos", _file.getUrl());
    }
    
    @Test
	public void deleteTest() {
    	File _filedeleted = new File(1,"Giacomo","Dos",22, "cotto");
		when(fileRepository.findOneTest(1)).thenReturn(_filedeleted);
		File returnedFile = fileServiceImpl.deleteTest(1);
		assertEquals(_filedeleted, returnedFile);
	}
}
