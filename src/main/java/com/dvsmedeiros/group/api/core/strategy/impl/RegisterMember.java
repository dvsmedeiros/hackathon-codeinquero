package com.dvsmedeiros.group.api.core.strategy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.group.api.domain.Member;

@Component
public class RegisterMember implements IStrategy<Member>{

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Member> appFacade;
	
	@Override
	public void process(Member aEntity, INavigationCase<Member> aCase) {
		appFacade.save(aEntity, new BusinessCaseBuilder().build());		
	}

}
