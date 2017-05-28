package com.dvsmedeiros.group.api.core.navigation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.thymeleaf.util.ListUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Link;

public class UpdateLinkActivity implements IStrategy<Link> {

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Link> appFacade;


	@Override
	public void process(Link aEntity, INavigationCase<Link> aCase) {
		Filter<Link> filter = new Filter<>(Link.class);
		filter.getEntity().setIdMessage(aEntity.getIdMessage());
		Chat chatEntity = new Chat();
		chatEntity.setChatId(aEntity.getChat().getChatId());
		filter.getEntity().setChat(chatEntity);

		List<Link> linkList = appFacade
				.find(filter, new BusinessCaseBuilder<Link>().withName("FIND_LINK_BY_LINK_AND_CHAT_ID").build())
				.getEntity();
		if (!ListUtils.isEmpty(linkList)) {
			Link link = linkList.get(0);
			link.setALike(aEntity.getaLike());
			link.setDislike(aEntity.getDislike());

			appFacade.update(link, new BusinessCaseBuilder<Link>().build());

		}

	}

}
