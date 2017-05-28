package com.dvsmedeiros.group.api.core.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.EntityRuleDefinition;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Link;

@Configuration
public class LinkNavigation {
	
	@Autowired
	private LinkExistingMemberActivity linkExistingMemberActivity;
	
	@Autowired
	private UpdateLinkActivity updateLinkActivity;
	
	@Autowired
	private FindLinkByIdMessageAndChatId findLinkByIdMessageAndChatId;
	
	
	
	@Bean(name="SAVE_LINK")
	public EntityRuleDefinition<Link> saveLinkNavigation() {

		EntityRuleDefinition<Link> activities = new EntityRuleDefinition<>();
		activities.addActivity(linkExistingMemberActivity); 
		return activities;
	}
	
	
	@Bean(name="UPDATE_LINK")
	public EntityRuleDefinition<Link> updateLinkNavigation() {

		EntityRuleDefinition<Link> activities = new EntityRuleDefinition<>();
		activities.addActivity(updateLinkActivity); 
		return activities;
	}
	
	@Bean(name="FIND_LINK_BY_LINK_AND_CHAT_ID")
	public EntityRuleDefinition<Filter<Link>> findLinkByMessageIdNavigation() {
		EntityRuleDefinition<Filter<Link>> activities = new EntityRuleDefinition<>();
		activities.addActivity(findLinkByIdMessageAndChatId); 
		return activities;
	}
	
	
	

}
