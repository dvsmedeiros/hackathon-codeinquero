package com.dvsmedeiros.group.api.core.navigation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ListUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Member;

@Component
public class ExistingMemberValidator implements IStrategy<Member> {

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Member> appFacade;

	@Override
	public void process(Member aEntity, INavigationCase<Member> aCase) {
		Filter<Member> filter = new Filter<>(Member.class);
		filter.getEntity().setMemberId(aEntity.getMemberId());

		List<Member> memberList = appFacade.find(filter, new BusinessCaseBuilder<Member>().build()).getEntities();
		if (!ListUtils.isEmpty(memberList)) {
			aEntity = memberList.get(0);
			aCase.suspendExecution();
		}

	}

}
