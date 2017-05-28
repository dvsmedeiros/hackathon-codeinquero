package com.dvsmedeiros.group.api.rest.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.IAdapter;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Link;
import com.dvsmedeiros.group.api.rest.request.LinkRequest;


@Component
public class LinkAdapter implements IAdapter<LinkRequest, Link>{

	
	@Autowired
	private MemberAdapter memberAdapter;
	
	@Override
	public Link adapt(LinkRequest source) {
		Link link = new Link();
		link.setALike(source.getLike());
		link.setDislike(source.getDislike());
		link.setALink(source.getLink());

		Chat chat = new Chat();
		chat.setChatId(source.getChatId());
		link.setChat(chat);
		link.setIdMessage(source.getMessageId());
		link.setMember(memberAdapter.adapt(source.getMember()));
		
		return link;
	}

}
