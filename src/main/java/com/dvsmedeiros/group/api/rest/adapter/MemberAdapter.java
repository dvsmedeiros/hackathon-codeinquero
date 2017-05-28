package com.dvsmedeiros.group.api.rest.adapter;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.IAdapter;
import com.dvsmedeiros.group.api.domain.Member;
import com.dvsmedeiros.group.api.rest.request.MemberRequest;

@Component
public class MemberAdapter implements IAdapter<MemberRequest, Member>{

	@Override
	public Member adapt(MemberRequest source) {
		Member member = new Member();
		member.setMemberId(source.getId());
		member.setFirstName(source.getFirst_name());
		member.setLastName(source.getLast_name());
		member.setInsertionDate(Calendar.getInstance());
		return member;
	}

}
