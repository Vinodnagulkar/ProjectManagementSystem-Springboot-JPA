package com.pms.model;

import java.util.Date;

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
	private String projectName;
	private String projectDiscription;
	private Date projectStartDate;
	private Date projectEndDate;
	

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
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projectName=" + projectName + ", projectDiscription=" + projectDiscription
				+ ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + "]";
	}
	
}
