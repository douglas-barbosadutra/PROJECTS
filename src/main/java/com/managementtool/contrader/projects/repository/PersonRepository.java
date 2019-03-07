package com.managementtool.contrader.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.managementtool.contrader.projects.domain.Person;
import com.managementtool.contrader.projects.dto.PersonDTO;

/**
 * Spring Data  repository for the Project entity.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
@Query(value = "select * from person where id=?", nativeQuery= true)
	Person findOne(int id);
@Query(value = "delete * from person where id=?", nativeQuery= true)
	Person delete(int id);
}
