package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
