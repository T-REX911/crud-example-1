package com.smartTech.crud_example_1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping("")
  public ResponseEntity<String> helloTenant (@RequestHeader("tenant_id") String tenantId){
    if (tenantId == null || tenantId == "") {
      return ResponseEntity.badRequest().body("tenant_id header is missing");
    }
    return ResponseEntity.ok("Received tenant_id: " + tenantId);
  }
}
