package com.dvsmedeiros.group.api.core.navigation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.controller.repository.ChatRepository;
import com.dvsmedeiros.group.api.domain.Chat;

@Component
public class FindChatByChatId implements IStrategy<Filter<Chat>>{

	@Autowired
	private ChatRepository chatRepository;
	
	

	@Override
	public void process(Filter<Chat> aEntity, INavigationCase<Filter<Chat>> aCase) {
		List<Chat> chatList = chatRepository.findByChatId(aEntity.getEntity().getChatId());
		aCase.getResult().addEntity(chatList);
		
	}

}
