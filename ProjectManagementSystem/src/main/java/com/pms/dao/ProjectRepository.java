package com.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Project;

/**
 * @author vinod.nagulkar
 *
 */
/*This is Project Repository for Project entity*/
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
