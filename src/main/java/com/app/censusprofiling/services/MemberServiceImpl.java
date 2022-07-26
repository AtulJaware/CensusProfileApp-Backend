package com.app.censusprofiling.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.MemberDto;
import com.app.censusprofiling.entity.Address;
import com.app.censusprofiling.entity.Member;
import com.app.censusprofiling.exception.MemberAlreadyExistsException;
import com.app.censusprofiling.exception.MemberNotFoundException;
import com.app.censusprofiling.repository.IMemberRepo;

@Service
public class MemberServiceImpl implements IMemberService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IMemberRepo iMemberRepo;
	
	@Override
	public List<Member> getAllMembers() {
		
		return iMemberRepo.findAll();
	}

	@Override
	public MemberDto getMemberDto(int id) throws MemberNotFoundException {
		Optional<Member> memberData = iMemberRepo.findById(id);
		if(!memberData.isEmpty()) {
			Member mem = memberData.get();
			MemberDto memDto = new MemberDto();
			memDto.setMemId(mem.getMemId());
			memDto.setFirstName(mem.getFirstName());
			memDto.setLastName(mem.getLastName());
			memDto.setDOB(mem.getDOB());
			memDto.setGender(mem.getGender());
			memDto.setMarital_status(mem.getMarital_status());
			memDto.setQualification(mem.getQualification());
			memDto.setRelationShip(mem.getRelationShip());
			
			memDto.setId(mem.getAddress().getId());
			memDto.setD_no(mem.getAddress().getD_no());
			memDto.setStreet(mem.getAddress().getStreet());
			memDto.setCity(mem.getAddress().getCity());
			memDto.setState(mem.getAddress().getState());
			memDto.setPincode(mem.getAddress().getPincode());
			return memDto;
		}
		else {
			LOGGER.error("Member Not Found in getMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public Member addMember(MemberDto member) throws MemberAlreadyExistsException {
		Optional<Member> memberData = iMemberRepo.findById(member.getMemId());
		
		if(memberData.isEmpty()) {
			Member mem = new Member();
			mem.setMemId(member.getMemId());
			mem.setFirstName(member.getFirstName());
			mem.setLastName(member.getLastName());
			mem.setDOB(member.getDOB());
			mem.setGender(member.getGender());
			mem.setMarital_status(member.getMarital_status());
			mem.setQualification(member.getQualification());
			mem.setRelationShip(member.getRelationShip());
			
			Address add =new Address();
			add.setId(member.getId());
			add.setD_no(member.getD_no());
			add.setStreet(member.getStreet());
			add.setCity(member.getCity());
			add.setState(member.getState());
			add.setPincode(member.getPincode());
			mem.setAddress(add);
			return iMemberRepo.save(mem);
		}
		else {
			LOGGER.error("Member already Found in addMember");
			throw new MemberAlreadyExistsException("Member already exists with id "+member.getMemId());
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
			member.setMemId(id);
			return iMemberRepo.save(member);
		}
		else {
			LOGGER.error("Member Not Found in updateMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public List<Member> findByFname(String fname) throws MemberNotFoundException{
		return iMemberRepo.findByFirstName(fname);
	}

	@Override
	public List<Member> findByLname(String lname) throws MemberNotFoundException{
		return iMemberRepo.findByLastName(lname);
	}

	@Override
	public List<Member> findByDob(LocalDate dob) throws MemberNotFoundException{
		return iMemberRepo.findByDOB(dob);
	}

	@Override
	public Member addMember(Member member) throws MemberAlreadyExistsException {
		Optional<Member> memberData = iMemberRepo.findById(member.getMemId());
		if(memberData.isEmpty()) {
			return iMemberRepo.save(member);
		}
		else {
			LOGGER.error("Member already Found in addMember");
			throw new MemberAlreadyExistsException("Member already exists with id "+member.getMemId());
		}
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
}
