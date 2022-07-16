package com.project.CensusProfiling.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.Member;
import com.project.CensusProfiling.Exception.MemberAlreadyExistsException;
import com.project.CensusProfiling.Exception.MemberNotFoundException;
import com.project.CensusProfiling.Repository.IMemberRepo;

@Service
public class MemberServiceImpl implements IMemberService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IMemberRepo iMemberRepo;
	
	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return iMemberRepo.findAll();
	}

	@Override
	public Optional<Member> getMember(int id) throws MemberNotFoundException {
		Optional<Member> memberData = iMemberRepo.findById(id);
		if(!memberData.isEmpty()) {
			return iMemberRepo.findById(id);
		}
		else {
			LOGGER.error("Member Not Found in getMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public Member addMember(Member member) throws MemberAlreadyExistsException {
		Optional<Member> memberData = iMemberRepo.findById(member.getId());
		if(memberData.isEmpty()) {
			return iMemberRepo.save(member);
		}
		else {
			LOGGER.error("Member already Found in addMember");
			throw new MemberAlreadyExistsException("Member already exists with id "+member.getId());
		}
	}

	@Override
	public Optional<Member> deleteMember(int id) throws MemberNotFoundException {
		Optional<Member> memberData = iMemberRepo.findById(id);
		if(!memberData.isEmpty()) {
			iMemberRepo.deleteById(id);
			return memberData;
		}
		else {
			LOGGER.error("Member Not Found in deleteMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public Member updateMember(int id, Member member) throws MemberNotFoundException {
		Optional<Member> memberData = iMemberRepo.findById(id);
		if(!memberData.isEmpty()) {
			member.setId(id);
			return iMemberRepo.save(member);
		}
		else {
			LOGGER.error("Member Not Found in updateMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public List<Member> findByFname(String fname) {
		return iMemberRepo.findByFirstName(fname);
	}

	@Override
	public List<Member> findByLname(String lname) {
		return iMemberRepo.findByLastName(lname);
	}

	@Override
	public List<Member> findByDob(LocalDate dob) {
		return iMemberRepo.findByDOB(dob);
	}

}
