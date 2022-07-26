package com.app.censusprofiling.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.MemberDto;
import com.app.censusprofiling.entity.Member;
import com.app.censusprofiling.exception.MemberAlreadyExistsException;
import com.app.censusprofiling.exception.MemberNotFoundException;

@Service
public interface IMemberService {

	public List<Member> getAllMembers();
	
	public MemberDto getMemberDto(int id) throws MemberNotFoundException;
	
	public Optional<Member> getMember(int id) throws MemberNotFoundException;
	
	public Optional<Member> deleteMember(int id) throws MemberNotFoundException;
	
	public Member updateMember(int id, Member member) throws MemberNotFoundException;
	
	public List<Member> findByFname(String fname) throws MemberNotFoundException;
	
	public List<Member> findByLname(String lname) throws MemberNotFoundException;
	
	public List<Member> findByDob(LocalDate dob) throws MemberNotFoundException;

	public Member addMember(MemberDto member) throws MemberAlreadyExistsException;

	public Member addMember(Member member) throws MemberAlreadyExistsException;
}
