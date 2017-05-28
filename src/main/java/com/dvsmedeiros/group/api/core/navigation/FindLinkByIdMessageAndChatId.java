package com.dvsmedeiros.group.api.core.navigation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.controller.repository.LinkRepository;
import com.dvsmedeiros.group.api.domain.Link;

@Component
public class FindLinkByIdMessageAndChatId implements IStrategy<Filter<Link>>{

	@Autowired
	private LinkRepository linkRepository;
	
	

	@Override
	public void process(Filter<Link> aEntity, INavigationCase<Filter<Link>> aCase) {
		List<Link> chatList = linkRepository.findByIdMessageAndChat_chatId(aEntity.getEntity().getIdMessage(), aEntity.getEntity().getChat().getChatId());
		aCase.getResult().addEntity(chatList);		
	}

}
