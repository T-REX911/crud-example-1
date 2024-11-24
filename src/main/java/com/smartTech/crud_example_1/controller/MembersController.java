package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.DTO.MemberDTO;
import com.smartTech.crud_example_1.entity.Members;
import com.smartTech.crud_example_1.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Members")
public class MembersController {
  @Autowired
  private MembersService membersService;

  @GetMapping("")
  public ResponseEntity<List<Members>> getAllMembers(){
    List<Members> membersList = membersService.getAllMembersService();
    return ResponseEntity.ok(membersList);
  }
  @PostMapping("/add")
  public ResponseEntity<Members> addMember(@RequestBody Members members){
    Members newMembers = membersService.addMemberService(members);
    return ResponseEntity.ok(newMembers);
  }
  @PutMapping("/update")
  public ResponseEntity<Members> updateMember(@RequestBody Members members){
    Members updatedMember = membersService.updateMemberService(members);
    return ResponseEntity.ok(updatedMember);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteMember(@PathVariable int id){
    return ResponseEntity.ok(membersService.deleteMemberService(id));
  }

  @PutMapping("/assign")
  public ResponseEntity<Members> assignBookToMember(@RequestBody MemberDTO memberDTO){
    Members members = membersService.assignBookToMemberService(memberDTO);
    return ResponseEntity.ok(members);
  }
}
