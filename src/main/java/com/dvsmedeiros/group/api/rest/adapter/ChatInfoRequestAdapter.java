package com.dvsmedeiros.group.api.rest.adapter;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.IAdapter;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.ChatCategory;
import com.dvsmedeiros.group.api.rest.request.ChatInfoRequest;

@Component
public class ChatInfoRequestAdapter implements IAdapter<ChatInfoRequest, Chat>{

	@Override
	public Chat adapt(ChatInfoRequest source) {
		Chat chat = new Chat();
		chat.setDescription(source.getDescription());
		
		ChatCategory category = new ChatCategory();
		category.setDescription(source.getCategory());
		
		chat.setChatCategory(category);
		chat.setChatId(source.getChatId());
		
		return chat;
	}

}
