package com.pms.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.ProjectRepository;
import com.pms.model.Project;
import com.pms.service.ProjectServiceApi;

@Service
public class ProjectServiceImpl implements ProjectServiceApi {
	@Autowired
	ProjectRepository projectRepository;
	
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
	Date currentDate = new Date(); 

	@Override
	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.getOne(id);
	}

	@Override
	public Project updateProject(Project project,Long id) {
		// TODO Auto-generated method stub
		Project p=projectRepository.getOne(id);
		System.out.println("project"+project);
		System.out.println("p"+p);
		
		p.setProjectDiscription(project.getProjectDiscription());
		p.setProjectName(project.getProjectName());
		p.setProjectStartDate(project.getProjectStartDate());
		p.setProjectEndDate(project.getProjectEndDate());
		return projectRepository.save(p);
	}

	@Override
	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

}
