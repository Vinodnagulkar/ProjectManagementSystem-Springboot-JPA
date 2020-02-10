package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * @author vinod.nagulkar
 * This is project entity 
 */
@Entity
@Component
@Table
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String projectId;
	private String projectName;
	private String projectDiscription;
	private String projectStartDate;
	private String projectEndDate;
	

	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDiscription() {
		return projectDiscription;
	}
	public void setProjectDiscription(String projectDiscription) {
		this.projectDiscription = projectDiscription;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", projectDiscription=" + projectDiscription + ", projectStartDate=" + projectStartDate
				+ ", projectEndDate=" + projectEndDate + "]";
	}
	
}
