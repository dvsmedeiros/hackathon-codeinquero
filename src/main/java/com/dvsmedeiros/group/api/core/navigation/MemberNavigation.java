package com.dvsmedeiros.group.api.core.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.EntityRuleDefinition;
import com.dvsmedeiros.group.api.domain.Member;

@Configuration
public class MemberNavigation {
		
	@Autowired
	private ExistingMemberValidator existingMemberValidator;
	
	@Autowired
	private RegisterMember registerMember;
	
	
	@Bean(name="SAVE_MEMBER")
	public EntityRuleDefinition<Member> navigation() {

		EntityRuleDefinition<Member> activities = new EntityRuleDefinition<>();
		activities.addActivity(existingMemberValidator);
		activities.addActivity(registerMember);
		return activities;
	}
	
}
