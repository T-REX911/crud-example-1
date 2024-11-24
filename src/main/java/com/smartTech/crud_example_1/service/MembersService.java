package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.DTO.MemberDTO;
import com.smartTech.crud_example_1.entity.Book;
import com.smartTech.crud_example_1.entity.Members;
import com.smartTech.crud_example_1.repository.BookRepository;
import com.smartTech.crud_example_1.repository.BorrowRecordsRepository;
import com.smartTech.crud_example_1.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersService {
  @Autowired
  private MembersRepository membersRepository;
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private BorrowRecordsRepository borrowRecordsRepository;


  public List<Members> getAllMembersService() {
    return membersRepository.findAll();
  }

  public Members addMemberService(Members members) {
    return membersRepository.save(members);
  }

  public Members updateMemberService(Members members) {
    Members existingMember = membersRepository.findById(members.getId()).orElse(null);
    existingMember.setName(members.getName());
    return membersRepository.save(existingMember);
  }

  public String deleteMemberService(int id) {
    membersRepository.deleteById(id);
    return "Member ID :" +id + " Deleted.";
  }

  public Members assignBookToMemberService(MemberDTO memberDTO) {
    Members existingMember = membersRepository.findById(memberDTO.getMember_id()).orElse(null);

    Book book = bookRepository.findById(memberDTO.getBook_id()).orElse(null);
    List<Book> bookList = new ArrayList<>();
    bookList.add(book);

    existingMember.setBookList(bookList);

    return membersRepository.save(existingMember);

  }
}
