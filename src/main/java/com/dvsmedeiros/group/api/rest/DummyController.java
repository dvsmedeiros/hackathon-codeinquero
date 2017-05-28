package com.dvsmedeiros.group.api.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.core.controller.impl.Navigator;
import com.dvsmedeiros.group.api.controller.BaseController;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.ChatCategory;
import com.dvsmedeiros.group.api.domain.Link;
import com.dvsmedeiros.group.api.domain.LinkCategory;
import com.dvsmedeiros.group.api.domain.Member;
import com.dvsmedeiros.group.api.domain.Schedule;
import com.dvsmedeiros.group.api.domain.User;
import com.dvsmedeiros.group.api.rest.request.DummyRequest;

@Component
public class DummyController extends BaseController{
	
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Chat> appFacade;

	@Autowired
	@Qualifier("navigator")
	private Navigator<Chat> navigator;
	
	
	@ResponseBody
	@RequestMapping(value = "/dummychats", method = RequestMethod.POST)
	public ResponseEntity<Chat> postChat(@RequestBody DummyRequest dummyRequest) {
		ResponseEntity<Chat> responseEntity;
		
		try {
			Chat chat = new Chat();
			chat.setInsertionDate(Calendar.getInstance());
			chat.setPhoto("C:\\caminho");
			chat.setDescription("Grupo Hackatlon");		
			chat.setChatName("Grupo Hackhatlon");
			
			ChatCategory chatCategory =new ChatCategory();
			chatCategory.setCode("JAVA");
			chatCategory.setDescription("Java");
			
			chat.setChatCategory(chatCategory);
			chat.setChatId(123123123);

			
			User user = new User();
			user.setAssociationCode("01010101");
			user.setEmail("rafael@email.com");
			user.setInsertionDate(Calendar.getInstance());
			user.setUsername("rnakasato");
			user.setPassword("encryptedPassword");
			
			Member member = new Member();
			member.setInsertionDate(Calendar.getInstance());
			
			
			Member member2 = new Member();
			member2.setInsertionDate(Calendar.getInstance());		

			
			List<Chat> chatList = new ArrayList<>();
			chatList.add(chat);
			member.setChatList(chatList);		
			member2.setChatList(chatList);
			
			
			LinkCategory linkCategory = new LinkCategory();
			linkCategory.setCode("JAVA");
			linkCategory.setDescription("Java");
			linkCategory.setInsertionDate(Calendar.getInstance());
			
			Link link = new Link();
			link.setIdMessage("000000001");
			link.setInsertionDate(Calendar.getInstance());
			link.setaLink("www.teste.com");
			link.setMember(member);
			link.setALike(50);
			link.setDislike(10);
			link.setChat(chat);
			
			
			Link link2 = new Link();
			link2.setIdMessage("000000002");
			link2.setInsertionDate(Calendar.getInstance());
			link2.setaLink("www.lol.com");
			link2.setMember(member);
			link2.setALike(25);
			link2.setDislike(2);
			link2.setChat(chat);
					
			List<Link> linkList = new ArrayList<>();
			linkList.add(link);
			linkList.add(link2);
			
			chat.setLinkList(linkList);
			
			Schedule schedule = new Schedule();
			schedule.setScheduleDate(Calendar.getInstance());
			schedule.setInsertionDate(Calendar.getInstance());
			
			List<Schedule> scheduleList = new ArrayList<>();
			scheduleList.add(schedule);
			
			chat.setScheduleList(scheduleList);
			
			List<Member> memberList = new ArrayList<>();
			memberList.add(member);
			memberList.add(member2);
			
			chat.setMemberList(memberList);
			
			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().build();
			appFacade.save(chat, aCase);			
			if (aCase.isSuspendExecution() || aCase.getResult().hasError() ) {
				responseEntity = new ResponseEntity<Chat>(HttpStatus.INTERNAL_SERVER_ERROR);
			}else{
				responseEntity = new ResponseEntity<Chat>(HttpStatus.OK);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Chat>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		responseEntity = new ResponseEntity<Chat>(HttpStatus.OK);
		
		return responseEntity;

	}
	
	
	@RequestMapping(value = "/chatdummy", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Chat> getChat() {
		ResponseEntity<Chat> responseEntity;
		
		Chat chat = new Chat();
		chat.setId(1);
		chat.setInsertionDate(Calendar.getInstance());
		chat.setPhoto("C:\\caminho");
		chat.setDescription("Grupo Hackatlon");		
		chat.setChatName("Grupo Hackhatlon");
		
		ChatCategory chatCategory =new ChatCategory();
		chatCategory.setId(1);;
		chatCategory.setCode("JAVA");
		chatCategory.setDescription("Java");
		
		chat.setChatCategory(chatCategory);
		chat.setChatId(123123123);

		
		User user = new User();
		user.setAssociationCode("01010101");
		user.setEmail("rafael@email.com");
		user.setId(1);
		user.setInsertionDate(Calendar.getInstance());
		user.setUsername("rnakasato");
		user.setPassword("encryptedPassword");
		
		Member member = new Member();
		member.setId(1);
		member.setInsertionDate(Calendar.getInstance());
		
		
		Member member2 = new Member();
		member2.setId(2);
		member2.setInsertionDate(Calendar.getInstance());		

		
		List<Chat> chatList = new ArrayList<>();
		chatList.add(chat);
		member.setChatList(chatList);		
		member2.setChatList(chatList);
		
		
		Link link = new Link();
		link.setIdMessage("000000001");
		link.setInsertionDate(Calendar.getInstance());
		link.setaLink("www.teste.com");
		link.setMember(member);
		link.setALike(50);
		link.setDislike(10);
		link.setId(1);
		link.setChat(chat);
		
		
		Link link2 = new Link();
		link2.setIdMessage("000000002");
		link2.setInsertionDate(Calendar.getInstance());
		link2.setaLink("www.lol.com");
		link2.setMember(member);
		link2.setALike(25);
		link2.setDislike(2);
		link2.setId(2);
		link2.setChat(chat);
				
		List<Link> linkList = new ArrayList<>();
		linkList.add(link);
		linkList.add(link2);
		
		chat.setLinkList(linkList);
		
		Schedule schedule = new Schedule();
		schedule.setScheduleDate(Calendar.getInstance());
		schedule.setInsertionDate(Calendar.getInstance());
		schedule.setId(1);
		
		List<Schedule> scheduleList = new ArrayList<>();
		scheduleList.add(schedule);
		
		chat.setScheduleList(scheduleList);
		
		
		List<Member> memberList = new ArrayList<>();
		memberList.add(member);
		memberList.add(member2);
		
		chat.setMemberList(memberList);
		
		
		
		responseEntity = new ResponseEntity<Chat>(chat,HttpStatus.OK);
		
		return responseEntity;

	}
	
	
	// REMOVER Após teste
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getPing() {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello man", HttpStatus.OK);

		return responseEntity;
	}

}
