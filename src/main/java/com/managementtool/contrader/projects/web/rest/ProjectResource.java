/*package com.managementtool.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.managementtool.contrader.domain.File;
import com.managementtool.contrader.domain.Person;
import com.managementtool.contrader.domain.Program;
import com.managementtool.contrader.domain.Project;
import com.managementtool.contrader.domain.Task;
import com.managementtool.contrader.service.FileService;
import com.managementtool.contrader.service.PersonService;
import com.managementtool.contrader.service.ProgramService;
import com.managementtool.contrader.service.ProjectService;
import com.managementtool.contrader.service.TaskService;
import com.managementtool.contrader.web.rest.errors.BadRequestAlertException;
import com.managementtool.contrader.web.rest.util.HeaderUtil;
import com.managementtool.contrader.web.rest.util.PaginationUtil;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.HashSet;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

///**
 * REST controller for managing Project.
 */
/*@RestController
@RequestMapping("/api")
public class ProjectResource {

    private final Logger log = LoggerFactory.getLogger(ProjectResource.class);

    private static final String ENTITY_NAME = "project";

    private final ProjectService projectService;
	private final ProgramService programService;
	private final PersonService personService;
	private final TaskService taskService;
	private final FileService fileService;

    public ProjectResource(ProjectService projectService,
						   ProgramService programService,
						   PersonService personService,
						   TaskService taskService,
						   FileService fileService) {
        this.projectService = projectService;
		this.programService = programService;
		this.personService = personService;
		this.taskService = taskService;
		this.fileService = fileService;
    }

    /**
     * POST  /projects : Create a new project.
     *
	 * @param file file to be uploaded
     * @param project the project and its tasks to save
     * @return the ResponseEntity with status 201 (Created) and with body the new project, or with status 400 (Bad Request) if the project has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
	 * @throws IOException if file saving fails
     */
  /*  @PostMapping("/projects")
    @Timed
    public ResponseEntity<Project> createProject(@RequestParam(value = "file", required = false) MultipartFile f, @RequestParam("project") String p) throws URISyntaxException, IOException {
        log.debug("REST request to save Project : {}", p);
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		
		Project project = mapper.readValue(p, Project.class);
        if (project.getId() != null) {
            throw new BadRequestAlertException("A new project cannot already have an ID", ENTITY_NAME, "idexists");
        }
		
		File file = null;
		if(f != null) {
			// Some sort of seeding for the filename
			Long now = Instant.now().toEpochMilli();
			
			java.io.File dest = new java.io.File("uploads/", now.toString() + "_" + f.getOriginalFilename());

			file = new File();
			file.mime(f.getContentType())
				.url(dest.getPath())
				.name(f.getOriginalFilename())
				.size(f.getSize());

			dest.getParentFile().mkdirs();
			f.transferTo(dest.getAbsoluteFile());
			
			fileService.save(file);
		}
		
		project.setFile(file);
		project = saveProject(project);
		
        return ResponseEntity.created(new URI("/api/projects/" + project.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, project.getId().toString()))
            .body(project);
    }

    /**
     * POST  /projects : Updates an existing project.
	 * Doesn't work as PUT for some reason, returns
	 * "java.io.IOException: UT000036: Connection terminated parsing multipart data"
     *
	 * @param file file to upload (if any)
     * @param project the project to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated project,
     * or with status 400 (Bad Request) if the project is not valid,
     * or with status 500 (Internal Server Error) if the project couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
	 * @throws IOException if there was an error saving the file
     */
   /* @PostMapping("/projects/edit")
    @Timed
    public ResponseEntity<Project> updateProject(@RequestParam(value = "file", required = false) MultipartFile f, @RequestParam("project") String p) throws URISyntaxException, IOException {
        log.debug("REST request to update Project : {}", p);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		
		Project project = mapper.readValue(p, Project.class);
		if (project.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		
		if(f != null) {
			// Some sort of seeding for the filename
			Long now = Instant.now().toEpochMilli();
			
			java.io.File dest = new java.io.File("uploads/", now.toString() + "_" + f.getOriginalFilename());
			
			File file = new File();
			file.mime(f.getContentType())
				.url(dest.getPath())
				.name(f.getOriginalFilename())
				.size(f.getSize());

			dest.getParentFile().mkdirs();
			f.transferTo(dest.getAbsoluteFile());
			
			fileService.save(file);
			project.setFile(file);
		}
		
        project = saveProject(project);
		
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, project.getId().toString()))
            .body(project);
    }

	private Project saveProject(Project project) {
		project.setCurrentTask(null);	// Until a better solution is found
		Set<Task> tasks = project.getTasks();
		
		// Check if program is new or existing
		Program program = project.getProgram();
		if(program.getId() == null) {
			program = programService.save(program);
			project.setProgram(program);
		}
		
		// Check if headPerson is new or existing
		Person headPerson = project.getHeadPerson();
		if(headPerson.getId() == null) {
			headPerson = personService.save(headPerson);
			project.setHeadPerson(headPerson);
		}
		
		project = projectService.save(project);
		
		// Remove unselected tasks
		Set<Task> allTasks = new HashSet<>(taskService.findByProject(project));
		allTasks.removeAll(tasks);
		taskService.delete(allTasks);
		
		// Set the task's project id
		// Should be done in the frontend?
		for(Task task : tasks) {
			task.setProject(project);
		}
		tasks = new HashSet<>(taskService.save(tasks));
		project.setTasks(tasks);
		
		if(!tasks.isEmpty()) {
			// Set the project's current task
			Task[] tasksArr = new Task[0];
			tasksArr = tasks.toArray(tasksArr);
			// Set the last task created for now
			project.setCurrentTask(tasksArr[tasksArr.length - 1]);
			project = projectService.save(project);
		}
		return project;
	}

    /**
     * GET  /projects : get all the projects.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of projects in body
     */
  /*  @GetMapping("/projects")
    @Timed
    public ResponseEntity<List<Project>> getAllProjects(Pageable pageable) {
        log.debug("REST request to get a page of Projects");
        Page<Project> page = projectService.findAll(pageable);
		for(Project p : page) {
			p.setTasks(null);
		}
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/projects");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

	public class SingleProjectModel {
		private List<Task> tasks;
		private Project project;
		
		public List<Task> getTasks() {
			return tasks;
		}
		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}
		public SingleProjectModel tasks(List<Task> tasks) {
			this.tasks = tasks;
			return this;
		}
		
		public Project getProject() {
			return project;
		}
		public void setProject(Project project) {
			this.project = project;
		}
		public SingleProjectModel project(Project project) {
			this.project = project;
			return this;
		}
	}
    /**
     * GET  /projects/:id : get the "id" project.
     *
     * @param id the id of the project to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the project, or with status 404 (Not Found)
     */
  /*  @GetMapping("/projects/{id}")
    @Timed
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        log.debug("REST request to get Project : {}", id);
        Optional<Project> prj = projectService.findOne(id);
		if(!prj.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Project project = prj.get();
		
		project.setTasks(new HashSet<>(taskService.findByProject(project)));
		for(Task task : project.getTasks()) {
			task.setProject(null);
		}
		
        return ResponseEntity.ok(project);
    }

    /**
     * DELETE  /projects/:id : delete the "id" project.
     *
     * @param id the id of the project to delete
     * @return the ResponseEntity with status 200 (OK)
     */
  /*  @DeleteMapping("/projects/{id}")
    @Timed
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        log.debug("REST request to delete Project : {}", id);
		Project prj = new Project();
		prj.setId(id);
		prj.setName("");
		prj.setLink("");
		
		prj = projectService.save(prj);
		
		List<Task> tasks = taskService.findByProject(prj);
		taskService.delete(tasks);
		
        projectService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
	
	public class DataModel {
		private List<Program> programs;
		private List<Person> people;
		private List<Task> tasks;
		
		public List<Program> getPrograms() {
			return programs;
		}
		public void setPrograms(List<Program> programs) {
			this.programs = programs;
		}
		public DataModel programs(List<Program> programs) {
			this.programs = programs;
			return this;
		}
		
		public List<Person> getPeople() {
			return people;
		}
		public void setPeople(List<Person> people) {
			this.people = people;
		}
		public DataModel people(List<Person> people) {
			this.people = people;
			return this;
		}
		
		public List<Task> getTasks() {
			return tasks;
		}
		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}
		public DataModel tasks(List<Task> tasks) {
			this.tasks = tasks;
			return this;
		}
	}
	
	/**
	 * GET /projects/data : get data for selects
	 * 
	 * @return data
	 */
	/*@GetMapping("/projects/data")
	@Timed
	public ResponseEntity<DataModel> getData() {
		DataModel data = new DataModel();
		data.programs(programService.findAll())
			.people(personService.findAll())
			.tasks(taskService.findAll());
		
		return ResponseEntity.ok(data);
	}
}*/
