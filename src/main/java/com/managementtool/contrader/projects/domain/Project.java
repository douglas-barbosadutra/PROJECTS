package com.managementtool.contrader.projects.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Project.
 */
@Entity
@Table(name = "project")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "jhi_link", nullable = false)
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name = "added_value")
    private Float addedValue;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Column(name = "next_critical_date")
    private ZonedDateTime nextCriticalDate;
	
	@ManyToOne
	@JsonIgnoreProperties("")
	private File file;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Program program;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Person headPerson;

    @OneToMany(mappedBy = "project")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnoreProperties({"project"})
    private Set<Task> tasks = new HashSet<>();

    @OneToOne
    @JoinColumn(unique = true)
    @JsonIgnoreProperties({"project"})
    private Task currentTask;
    
    
    
    public Project(int id, @NotNull String name, @NotNull float addedValue, @NotNull String description, @NotNull String link, @NotNull String status, ZonedDateTime endDate, ZonedDateTime nextCriticalDate ,File file, Program program, Person headPerson, Task currentTask, Set<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.addedValue = addedValue;
		this.description = description;
		this.link = link;
		this.status = status;
		this.endDate = endDate;
		this.nextCriticalDate = nextCriticalDate;
		this.file = file;
		this.program = program;
		this.headPerson = headPerson;
		this.currentTask = currentTask;
		this.tasks = tasks;
		
		
		
	}



	public Project() {
	}

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public Project link(String link) {
        this.link = link;
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public Project description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAddedValue() {
        return addedValue;
    }

    public Project addedValue(Float addedValue) {
        this.addedValue = addedValue;
        return this;
    }

    public void setAddedValue(Float addedValue) {
        this.addedValue = addedValue;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public Project endDate(ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public ZonedDateTime getNextCriticalDate() {
        return nextCriticalDate;
    }

    public Project nextCriticalDate(ZonedDateTime nextCriticalDate) {
        this.nextCriticalDate = nextCriticalDate;
        return this;
    }

    public void setNextCriticalDate(ZonedDateTime nextCriticalDate) {
        this.nextCriticalDate = nextCriticalDate;
    }
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Project file(File file) {
		this.file = file;
		return this;
	}

    public String getStatus() {
        return status;
    }

    public Project status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Program getProgram() {
        return program;
    }

    public Project program(Program program) {
        this.program = program;
        return this;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Person getHeadPerson() {
        return headPerson;
    }

    public Project headPerson(Person person) {
        this.headPerson = person;
        return this;
    }

    public void setHeadPerson(Person person) {
        this.headPerson = person;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Project tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Project addTasks(Task task) {
        this.tasks.add(task);
        task.setProject(this);
        return this;
    }

    public Project removeTasks(Task task) {
        this.tasks.remove(task);
        task.setProject(null);
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public Project currentTask(Task task) {
        this.currentTask = task;
        return this;
    }

    public void setCurrentTask(Task task) {
        this.currentTask = task;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        if (project.getId() == 0 || getId() == 0) {
            return false;
        }
        return Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", link='" + getLink() + "'" +
            ", description='" + getDescription() + "'" +
            ", addedValue=" + getAddedValue() +
            ", endDate='" + getEndDate() + "'" +
            ", nextCriticalDate='" + getNextCriticalDate() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
