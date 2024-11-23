package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Test2.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
