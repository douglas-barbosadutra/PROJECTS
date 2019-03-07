package com.managementtool.contrader.projects.repository;


import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.domain.Task;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Task entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	@Query(value = "select * from task where id=?", nativeQuery= true)
	Task findOne(int id);
@Query(value = "delete * from task where id=?", nativeQuery= true)
	Task delete(int id);
}