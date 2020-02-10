package com.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pms.model.Project;
import com.pms.service.ProjectServiceApi;
import com.pms.util.PmsURI;

/**
 * @author vinod.nagulkar
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class ProjectController
{
	@Autowired
	ProjectServiceApi projectServiceApi;
	
	/**
	 * This API gets the project object as input and sends it to service layer
	 * @PostMapping is used to handle POST type of request method
	 * @RequestBody annotation binds the HTTPRequest body to the domain object.
	 * */
	@PostMapping(PmsURI.ADD_PROJECT)
	public ResponseEntity<?> addProject(@RequestBody Project project) 
	{
		System.out.println(project);
		 return new ResponseEntity<Project>(projectServiceApi.addProject(project),HttpStatus.OK);
	}
	
	/** 
	 * This API fetch all project objects from database and returns it through URL 
	 * @GetMapping maps the GET request to the particular method 
	 *@return List of project objects
	 * */
	@GetMapping(PmsURI.GET_ALL_PROJECTS)
	public ResponseEntity<?>getAllProjects()
	{
		List<Project>projectList=projectServiceApi.getAllProjects();
		if(!projectList.isEmpty())
		return new ResponseEntity<>(projectList,HttpStatus.OK);
		else
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/** 
	 * This API fetch the project object by ID from database and returns it through URL 
	 * @GetMapping maps the GET request to the particular method 
	 * @return: Project object 
	 * */
	@GetMapping(PmsURI.GET_PROJECT)
	public ResponseEntity<Optional<Project>> getProjectById(@PathVariable Long id) 
	{
		Optional<Project> project=projectServiceApi.getProjectById(id);
		System.out.println(project+"************************");
		if(project.isPresent()) 
			return new ResponseEntity<Optional<Project>>(project,HttpStatus.FOUND);
		else
			return new ResponseEntity<Optional<Project>>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This API gets the input as Project object and ID of the project which is going to update
	 *@PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.
	 *@PathVariable annotation is used to bind the URI template variables to the handler method parameters
	 *@return Project object
	 **/
	@PutMapping(PmsURI.UPDATE_PROJECT)
	public ResponseEntity<Project> updateProject(@RequestBody Project project,@PathVariable Long id) 
	{
		Project updatedProject=projectServiceApi.updateProject(project,id);
		return new ResponseEntity<Project>(updatedProject,HttpStatus.OK);
	}
	
	/**
	 * This API gets ID as input and delete that Project by ID
	 *@DeleteMapping annotation for mapping HTTP DELETE requests onto specific handler methods
	 *@PathVariable annotation is used to bind the URI template variables to the handler method parameters
	 **/
	@DeleteMapping(PmsURI.DELETE_PROJECT)
	public ResponseEntity<Project> deleteProject(@PathVariable Long id) {
		System.out.println("=============================================="+id);
	projectServiceApi.deleteProject(id);
	return new ResponseEntity<Project>(HttpStatus.OK);
	}
}
