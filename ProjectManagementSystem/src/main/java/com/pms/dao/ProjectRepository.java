package com.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
