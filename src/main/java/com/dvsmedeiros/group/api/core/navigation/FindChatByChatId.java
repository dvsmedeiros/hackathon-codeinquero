package com.dvsmedeiros.group.api.core.navigation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.group.api.controller.repository.ChatRepository;
import com.dvsmedeiros.group.api.domain.Chat;

public class FindChatByChatId implements IStrategy<Chat>{

	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public void process(Chat aEntity, INavigationCase<Chat> aCase) {
		List<Chat> chatList = chatRepository.findByChatId(aEntity.getChatId());
		
	}

}
