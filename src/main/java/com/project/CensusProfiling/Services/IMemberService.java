package com.project.CensusProfiling.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.MemberEntity;
import com.project.CensusProfiling.Exception.MemberAlreadyExistsException;
import com.project.CensusProfiling.Exception.MemberNotFoundException;

@Service
public interface IMemberService {

	public List<MemberEntity> getAllMembers();
	
	public Optional<MemberEntity> getMember(int id) throws MemberNotFoundException;
	
	public MemberEntity addMember(MemberEntity  memberEntity) throws MemberAlreadyExistsException;
	
	public Optional<MemberEntity> deleteMember(int id) throws MemberNotFoundException;
	
	public MemberEntity updateMember(int id, MemberEntity memberEntity) throws MemberNotFoundException;
	
	public List<MemberEntity> findByFname(String fname);
	
	public List<MemberEntity> findByLname(String lname);
	
	public List<MemberEntity> findByDob(LocalDate dob);
}
