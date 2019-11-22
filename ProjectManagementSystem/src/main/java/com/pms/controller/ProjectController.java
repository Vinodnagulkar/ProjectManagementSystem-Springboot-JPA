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
	
	@PostMapping("/pms/project/addProject")
	public Project addProject(@RequestBody Project project) 
	{
		return projectServiceApi.addProject(project);
	}
	
	@GetMapping("/pms/project/getAllProjects")
	public List<Project>getAllProjects()
	{
		return projectServiceApi.getAllProjects();
	}
	
	@GetMapping("/pms/project/getProjectById/{id}")
	public Project getProjectById(@PathVariable Long id) 
	{
	return	projectServiceApi.getProjectById(id);
	}
	
	@PutMapping("/pms/project/updateProject/{id}")
	public Project updateProject( @RequestBody Project project,@PathVariable Long id) 
	{
		return projectServiceApi.updateProject(project,id);
		}
	
	@DeleteMapping("/pms/project/deleteProject/{id}")
	public void deleteProject(@PathVariable Long id) {
	projectServiceApi.deleteProject(id);
	}
}
