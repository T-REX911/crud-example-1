package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members,Integer> {
}
