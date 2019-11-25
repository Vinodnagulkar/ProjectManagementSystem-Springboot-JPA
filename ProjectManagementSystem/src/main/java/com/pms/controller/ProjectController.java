package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pms.model.Project;
import com.pms.service.ProjectServiceApi;

/**
 * @author vinod.nagulkar
 *
 */
@RestController
public class ProjectController 
{
	@Autowired
	ProjectServiceApi projectServiceApi;
	
	/*This method gets the project object as input and sends it to service layer
	 * @PostMapping is used to handle POST type of request method
	 * @RequestBody annotation binds the HTTPRequest body to the domain object. */
	@PostMapping("/pms/project/addProject")
	public Project addProject(@RequestBody Project project) 
	{
		return projectServiceApi.addProject(project);
	}
	
	/* This API fetch all project objects from database and returns it through URL 
	 * @GetMapping maps the GET request to the particular method 
	 * Return: List of project object*/
	@GetMapping("/pms/project/getAllProjects")
	public List<Project>getAllProjects()
	{
		return projectServiceApi.getAllProjects();
	}
	
	/* This API fetch the project object by ID from database and returns it through URL 
	 * @GetMapping maps the GET request to the particular method 
	 * Return: Project object */
	@GetMapping("/pms/project/getProjectById/{id}")
	public Project getProjectById(@PathVariable Long id) 
	{
	return	projectServiceApi.getProjectById(id);
	}
	
	
	/*This API gets the input as Project object and ID of the project which is going to update
	 *@PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.
	 *@PathVariable annotation is used to bind the URI template variables to the handler method parameters*/
	@PutMapping("/pms/project/updateProject/{id}")
	public Project updateProject( @RequestBody Project project,@PathVariable Long id) 
	{
		return projectServiceApi.updateProject(project,id);
	}
	
	/*This API gets ID as input and delete that Project by ID
	 *@DeleteMapping annotation for mapping HTTP DELETE requests onto specific handler methods
	 *@PathVariable annotation is used to bind the URI template variables to the handler method parameters*/
	@DeleteMapping("/pms/project/deleteProject/{id}")
	public void deleteProject(@PathVariable Long id) {
	projectServiceApi.deleteProject(id);
	}
}
