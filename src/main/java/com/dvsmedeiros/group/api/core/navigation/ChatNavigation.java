package com.dvsmedeiros.group.api.core.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.EntityRuleDefinition;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Chat;

@Configuration
public class ChatNavigation {
	
	@Autowired
	private FindChatByChatId findChatByChatId;
	
	
	
	@Bean(name="FIND_CHAT_BY_ID")
	public EntityRuleDefinition<Filter<Chat>> navigation() {

		EntityRuleDefinition<Filter<Chat>> activities = new EntityRuleDefinition<>();
		activities.addActivity(findChatByChatId);
		return activities;
	}

}
