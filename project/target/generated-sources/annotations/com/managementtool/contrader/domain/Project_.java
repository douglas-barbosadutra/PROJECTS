package com.managementtool.contrader.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Project.class)
public abstract class Project_ {

	public static volatile SingularAttribute<Project, ZonedDateTime> endDate;
	public static volatile SingularAttribute<Project, ZonedDateTime> nextCriticalDate;
	public static volatile SingularAttribute<Project, String> link;
	public static volatile SingularAttribute<Project, Task> currentTask;
	public static volatile SingularAttribute<Project, String> description;
	public static volatile SingularAttribute<Project, Person> headPerson;
	public static volatile SingularAttribute<Project, Program> program;
	public static volatile SingularAttribute<Project, File> file;
	public static volatile SingularAttribute<Project, String> name;
	public static volatile SingularAttribute<Project, Float> addedValue;
	public static volatile SingularAttribute<Project, Integer> id;
	public static volatile SetAttribute<Project, Task> tasks;
	public static volatile SingularAttribute<Project, String> status;

}

