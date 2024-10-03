package com.pms.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.ProjectRepository;
import com.pms.model.Project;
import com.pms.service.ProjectServiceApi;

/**
 * @author vinod.nagulkar
 * This is service implementation class which have CRUD methods that contains business logic
 */

@Service
public class ProjectServiceImpl implements ProjectServiceApi {
	
	/**
	 * This is ProjectRepository instance
	 */
	@Autowired
	ProjectRepository projectRepository;
	
	/**
	 * This is Date and Time API instance
	 */
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
	Date currentDate = new Date(); 

	/**
	 * This method gets Project object as input and send it to DAO layer.
	 * */
	@Override
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}

	/**
	 * This method returns all Project objects in a List which is fetch from database.
	 * @return List of Project object
	 * */
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	/** 
	 * This method fetch the project object by ID from database and returns it.
	 * @return Project object
	 * */
	@Override
	public Optional<Project> getProjectById(Long id) {
		return projectRepository.findById(id);
	}
	
	/**
	 * This method gets the input as Project object and ID of the project which is going to update
	 * @return Project object
	 * */
	@Override
	public Project updateProject(Project project, Long id) {
		Project p = projectRepository.getOne(id);
		p.setProjectDiscription(project.getProjectDiscription());
		p.setProjectName(project.getProjectName());
		p.setProjectStartDate(project.getProjectStartDate());
		p.setProjectEndDate(project.getProjectEndDate());
		return projectRepository.save(p);
	}

	/**
	 * This method gets ID as input and delete that Project object from DB
	 * */
	@Override
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

}
