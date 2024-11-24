package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.BorrowRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordsRepository extends JpaRepository<BorrowRecords,Integer> {
}
