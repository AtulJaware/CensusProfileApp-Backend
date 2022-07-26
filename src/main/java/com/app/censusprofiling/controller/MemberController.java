package com.app.censusprofiling.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.censusprofiling.dto.MemberDto;
import com.app.censusprofiling.entity.Member;
import com.app.censusprofiling.exception.MemberAlreadyExistsException;
import com.app.censusprofiling.exception.MemberNotFoundException;
import com.app.censusprofiling.services.IMemberService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController {
	
	@Autowired
	private IMemberService iMemberService;
	

	// get all members
	
	@GetMapping("/members")
	public List<Member> getAllMembers(){
		return iMemberService.getAllMembers();
	}
	// get member by id
	@GetMapping("/member/{id}")
	public MemberDto getMember(@PathVariable int id) throws MemberNotFoundException{
		return iMemberService.getMemberDto(id);
	}
	
	@PostMapping("/member/add")
	public Member addMember(@Valid @RequestBody Member  member) throws MemberAlreadyExistsException{
		return iMemberService.addMember(member);
	}
	
	@PostMapping("/memberDto/add")
	public Member addMember(@Valid @RequestBody MemberDto  member) throws MemberAlreadyExistsException{
		return iMemberService.addMember(member);
	}
	
	// delete member by id
	@DeleteMapping("/member/delete/{id}")
	public Optional<Member> deleteMember(@PathVariable int id) throws MemberNotFoundException{
		return iMemberService.deleteMember(id);
	}

	// update member by id
	@PutMapping("/member/update/{id}")
	public Member updateMember(@PathVariable int id, @Valid @RequestBody Member member) throws MemberNotFoundException{
		return iMemberService.updateMember(id, member);
	}

}
