package com.managementtool.contrader.repository;


import com.managementtool.contrader.domain.File;
import com.managementtool.contrader.domain.Person;
import com.managementtool.contrader.dto.NewFileDTO;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the File entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	@Query(value = "select * from file where id=?", nativeQuery= true)
	File findOneTest(int id);
	
	@Query(value = "delete * from file where id=?", nativeQuery= true)
	File delete(int id);
	
}