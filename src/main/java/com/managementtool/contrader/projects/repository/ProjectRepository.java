package com.managementtool.contrader.projects.repository;


import com.managementtool.contrader.projects.domain.Project;



import com.managementtool.contrader.projects.domain.Project;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Project entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	  @Query ( value = " select * from project where id =?", nativeQuery=true)

		


	  Project findOne(int id);

	    @Query(value = "delete * from project where id=?", nativeQuery= true)
	    
	  	Project delete(int id);


}
