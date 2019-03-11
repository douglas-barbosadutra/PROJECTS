package com.managementtool.contrader.projects.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managementtool.contrader.projects.domain.File;
import com.managementtool.contrader.projects.dto.NewFileDTO;

import com.managementtool.contrader.projects.web.rest.util.PaginationUtil;
import com.managementtool.contrader.projects.service.FileService;



/**
/* REST controller for managing File.
*/
 @RestController
 @RequestMapping("/File")
 public class FileResource {
	
	 private FileService fileService;


		@Autowired
		public FileResource (FileService fileService) {
			this.fileService =  fileService;
		}
		
		@CrossOrigin
		@RequestMapping(value = "/ShowFile", method = RequestMethod.GET)
		public List<NewFileDTO> getAll(){
			List<NewFileDTO> file = fileService.getAll();
			return file;
		}
		

		 @CrossOrigin
			@RequestMapping(value="/deleteFile", method = RequestMethod.GET)
			public boolean delete(@RequestParam(value="id") Long id) {
				fileService.delete(id);
				return true;
	}
		
		
		 @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
			@CrossOrigin
			public  NewFileDTO  newfile(
				@RequestParam(value="name") String name,
				@RequestParam(value="mime") String mime,
				@RequestParam(value="url") String url,
				@RequestParam(value="jhi_size") int size) {
				
				NewFileDTO newfileDTO = new NewFileDTO();
				newfileDTO.setName(name);
				newfileDTO.setMime(mime);
				newfileDTO.setUrl(url);
				newfileDTO.setSize(size);
				newfileDTO = fileService.save(newfileDTO);
				return newfileDTO;
			}
	
		 @CrossOrigin
		 @RequestMapping (value ="/updateFile", method= RequestMethod.POST)
		 public NewFileDTO update (
				 @RequestParam(value = "id") Long id,
				 @RequestParam(value="name") String name,
				 @RequestParam(value="mime") String mime,
				 @RequestParam(value="url") String url,
				 @RequestParam(value="jhi_size") int size
				 ) {
			 NewFileDTO newfileDTO = fileService.findOne(id);
			 newfileDTO.setName(name);
			 newfileDTO.setMime(mime);
			 newfileDTO.setUrl(url);
			 newfileDTO.setSize(size);
			 fileService.save(newfileDTO);
			return newfileDTO ; 
		 }
	
 
}