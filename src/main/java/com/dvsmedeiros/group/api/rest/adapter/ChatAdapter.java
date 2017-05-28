package com.dvsmedeiros.group.api.rest.adapter;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.IAdapter;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.rest.request.ChatRequest;

@Component
public class ChatAdapter implements IAdapter<ChatRequest, Chat>{

	@Override
	public Chat adapt(ChatRequest source) {
		Chat chat = new Chat();
		chat.setChatName(source.getTitle());
		chat.setChatId(source.getId());		
		
		return chat;
	}

}
