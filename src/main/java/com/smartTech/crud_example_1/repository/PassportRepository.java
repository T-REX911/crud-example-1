package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Integer> {
}
