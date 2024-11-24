package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.repository.BookRepository;
import com.smartTech.crud_example_1.repository.BorrowRecordsRepository;
import com.smartTech.crud_example_1.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRecordsService {
  @Autowired
  private BorrowRecordsRepository borrowRecordsRepository;
  @Autowired
  private MembersRepository membersRepository;
  @Autowired
  private BookRepository bookRepository;


}
