package com.app.censusprofiling.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.app.censusprofiling.entity.Member;
import com.app.censusprofiling.exception.MemberAlreadyExistsException;
import com.app.censusprofiling.exception.MemberNotFoundException;

@Service
public interface IMemberService {

	public List<Member> getAllMembers();
	
	public Optional<Member> getMember(int id) throws MemberNotFoundException;
	
	public Optional<Member> deleteMember(int id) throws MemberNotFoundException;
	
	public Member updateMember(int id, Member member) throws MemberNotFoundException;
	
	public List<Member> findByFname(String fname);
	
	public List<Member> findByLname(String lname);
	
	public List<Member> findByDob(LocalDate dob);

	public Member addMember(Member member) throws MemberAlreadyExistsException;
}
