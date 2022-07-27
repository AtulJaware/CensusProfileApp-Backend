package com.app.censusprofiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.app.censusprofiling.entity.Member;
import com.app.censusprofiling.exception.MemberAlreadyExistsException;
import com.app.censusprofiling.exception.MemberNotFoundException;
import com.app.censusprofiling.services.IMemberService;

@ExtendWith(MockitoExtension.class)
public class MemberTests {
	

	@Mock
	IMemberService iMemberService;

	@Test
	void addMemberTest() throws MemberAlreadyExistsException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		Member member = new Member(1,"name1","name2",localDate,"male","brother","Graduated","single");
		when(iMemberService.addMember(member)).thenReturn(member);
		assertEquals(iMemberService.addMember(member),member);
	}
	
	@Test
	void getMemberTest() throws MemberNotFoundException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		Member member = new Member(1,"name1","name2",localDate,"male","brother","Graduated","single");
		Optional<Member> OMemberEntity = Optional.of(member);
		when(iMemberService.getMember(1)).thenReturn(OMemberEntity);
		assertEquals(iMemberService.getMember(1).get(),member);
	}
	
	@Test
	void updateMemberTest() throws MemberNotFoundException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		Member member = new Member(1,"name1","name2",localDate,"male","brother","Graduated","single");
		when(iMemberService.updateMember(1,member)).thenReturn(member);
		assertEquals(iMemberService.updateMember(1,member),member);
	}
	
	@Test
	void deleteMemberTest() throws MemberNotFoundException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		Member member = new Member(1,"name1","name2",localDate,"male","brother","Graduated","single");
		Optional<Member> OMemberEntity = Optional.of(member);
		when(iMemberService.deleteMember(1)).thenReturn(OMemberEntity);
		assertEquals(iMemberService.deleteMember(1).get(),member);
	}

}
