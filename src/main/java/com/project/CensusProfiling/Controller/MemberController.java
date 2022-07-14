package com.project.CensusProfiling.Controller;

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

import com.project.CensusProfiling.Entity.MemberEntity;
import com.project.CensusProfiling.Exception.MemberAlreadyExistsException;
import com.project.CensusProfiling.Exception.MemberNotFoundException;
import com.project.CensusProfiling.Services.IMemberService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController {
	
	@Autowired
	private IMemberService iMemberService;
	

	// get all members
	
	@GetMapping("/member")
	public List<MemberEntity> getAllMembers(){
		return iMemberService.getAllMembers();
	}
	// get member by id
	@GetMapping("/member/{id}")
	public Optional<MemberEntity> getMember(@PathVariable int id) throws MemberNotFoundException{
		return iMemberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberEntity addMember(@Valid @RequestBody MemberEntity  memberEntity) throws MemberAlreadyExistsException{
		return iMemberService.addMember(memberEntity);
	}
	
	// delete member by id
	@DeleteMapping("/member/{id}")
	public Optional<MemberEntity> deleteMember(@PathVariable int id) throws MemberNotFoundException{
		return iMemberService.deleteMember(id);
	}

	// update member by id
	@PutMapping("/member/{id}")
	public MemberEntity updateMember(@PathVariable int id, @Valid @RequestBody MemberEntity memberEntity) throws MemberNotFoundException{
		return iMemberService.updateMember(id, memberEntity);
	}

}
