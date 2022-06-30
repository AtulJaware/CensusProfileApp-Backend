package com.project.CensusProfiling.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.MemberEntity;
import com.project.CensusProfiling.Exception.MemberAlreadyExistsException;
import com.project.CensusProfiling.Exception.MemberNotFoundException;
import com.project.CensusProfiling.Repository.IMemberRepo;

@Service
public class MemberServiceImpl implements IMemberService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IMemberRepo iMemberRepo;
	
	@Override
	public List<MemberEntity> getAllMembers() {
		// TODO Auto-generated method stub
		return iMemberRepo.findAll();
	}

	@Override
	public Optional<MemberEntity> getMember(int id) throws MemberNotFoundException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(id);
		if(!memberData.isEmpty()) {
			return iMemberRepo.findById(id);
		}
		else {
			LOGGER.error("Member Not Found in getMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public MemberEntity addMember(MemberEntity memberEntity) throws MemberAlreadyExistsException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(memberEntity.getId());
		if(memberData.isEmpty()) {
			return iMemberRepo.save(memberEntity);
		}
		else {
			LOGGER.error("Member already Found in addMember");
			throw new MemberAlreadyExistsException("Member already exists with id "+memberEntity.getId());
		}
	}

	@Override
	public Optional<MemberEntity> deleteMember(int id) throws MemberNotFoundException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(id);
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
	public MemberEntity updateMember(int id, MemberEntity memberEntity) throws MemberNotFoundException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(id);
		if(!memberData.isEmpty()) {
			memberEntity.setId(id);
			return iMemberRepo.save(memberEntity);
		}
		else {
			LOGGER.error("Member Not Found in updateMember");
			throw new MemberNotFoundException("Member Not Found with id "+id);
		}
	}

	@Override
	public List<MemberEntity> findByFname(String fname) {
		return iMemberRepo.findByFirstName(fname);
	}

	@Override
	public List<MemberEntity> findByLname(String lname) {
		return iMemberRepo.findByLastName(lname);
	}

	@Override
	public List<MemberEntity> findByDob(LocalDate dob) {
		return iMemberRepo.findByDOB(dob);
	}

}
