package com.dvsmedeiros.group.api.core.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.EntityRuleDefinition;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Member;

@Configuration
public class MemberNavigation {
		
	@Autowired
	private ExistingMemberValidator existingMemberValidator;
	
	@Autowired
	private RegisterMember registerMember;
	
	@Autowired
	private FindMemberByMemberId findMemberByMemberId;
	
	
	@Bean(name="SAVE_MEMBER")
	public EntityRuleDefinition<Member> navigation() {

		EntityRuleDefinition<Member> activities = new EntityRuleDefinition<>();
		activities.addActivity(existingMemberValidator);
		activities.addActivity(registerMember);
		return activities;
	}
	
	
	@Bean(name="FIND_MEMBER_BY_MEMBER_ID")
	public EntityRuleDefinition<Filter<Member>> findMemberIdNavigation() {

		EntityRuleDefinition<Filter<Member>> activities = new EntityRuleDefinition<>();
		activities.addActivity(findMemberByMemberId);
		return activities;
	}
	
}
