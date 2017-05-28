package com.dvsmedeiros.group.api.core.navigation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.controller.repository.MemberRepository;
import com.dvsmedeiros.group.api.domain.Member;

@Component
public class FindMemberByMemberId implements IStrategy<Filter<Member>>{

	@Autowired
	private MemberRepository memberRepository;
	
	

	@Override
	public void process(Filter<Member> aEntity, INavigationCase<Filter<Member>> aCase) {
		List<Member> memberList = memberRepository.findByMemberId(aEntity.getEntity().getMemberId());
		aCase.getResult().addEntity(memberList);
		
	}

}
