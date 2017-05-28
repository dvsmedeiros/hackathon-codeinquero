package com.dvsmedeiros.group.api.core.navigation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ListUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Link;
import com.dvsmedeiros.group.api.domain.Member;

@Component
public class LinkExistingMemberActivity implements IStrategy<Link> {
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Member> appFacade;

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Chat> chatFacade;
	
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Link> linkFacade;

	@Override
	public void process(Link aEntity, INavigationCase<Link> aCase) {
		
		Filter<Member> filter = new Filter<>(Member.class);
		filter.getEntity().setMemberId(aEntity.getMember().getMemberId());

		List<Member> memberList = appFacade.find(filter, new BusinessCaseBuilder<Member>().withName("FIND_MEMBER_BY_MEMBER_ID").build()).getEntity();
		if (!ListUtils.isEmpty(memberList)) {
			aEntity.setMember(memberList.get(0));			
		}else{
			appFacade.save(aEntity.getMember(),new BusinessCaseBuilder<Member>().build() );
		}
		
		
		Filter<Chat> chatFilter = new Filter<>(Chat.class);
		chatFilter.getEntity().setChatId(aEntity.getChat().getChatId());

		List<Chat> chatList = chatFacade.find(chatFilter, new BusinessCaseBuilder<Chat>().withName("FIND_CHAT_BY_ID").build()).getEntity();
		
		aEntity.setChat(null);
		linkFacade.save(aEntity, new BusinessCaseBuilder<Link>().build());
		if (!ListUtils.isEmpty(chatList)) {
			Chat chat = chatList.get(0);
			if (chat.getMemberList() == null) {
				chat.setMemberList(new ArrayList<>());
			}
			boolean exists = false;
			for (Member member : chat.getMemberList()) {
				if(member.getId() == aEntity.getMember().getId()){
					exists = true;
					break;
				}
			}
			if(!exists){				
				chat.getMemberList().add(aEntity.getMember());
			}
			
			if(ListUtils.isEmpty(chat.getLinkList())){
				chat.setLinkList(new ArrayList<>());
			}
			chat.getLinkList().add(aEntity);
			
			chatFacade.update(chat, new BusinessCaseBuilder<Chat>().build());				
		}		
		
		

	}



}
