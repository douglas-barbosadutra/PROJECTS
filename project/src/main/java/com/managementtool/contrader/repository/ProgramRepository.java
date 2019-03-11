package com.managementtool.contrader.repository;



import com.managementtool.contrader.domain.Program;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Program entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

  @Query ( value = " select * from program where id =?", nativeQuery=true)

	


Program findOne(int id);

  @Query(value = "delete * from program where id=?", nativeQuery= true)
  
	Program delete(int id);


	
	
}