package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.service.BorrowRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class BorrowRecordsController {
  @Autowired
  private BorrowRecordsService borrowRecordsService;

}
