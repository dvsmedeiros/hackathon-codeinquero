package com.dvsmedeiros.group.api.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.core.controller.impl.Navigator;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.group.api.controller.BaseController;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Link;
import com.dvsmedeiros.group.api.domain.Member;
import com.dvsmedeiros.group.api.domain.Schedule;
import com.dvsmedeiros.group.api.domain.User;

@Controller
public class ChatController extends BaseController {

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Chat> appFacade;

	@Autowired
	@Qualifier("navigator")
	private Navigator<Chat> navigator;

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Chat>> getAllGroups() {
		ResponseEntity<List<Chat>> responseEntity = null;

		try {
			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().build();
			Result result = appFacade.findAll(Chat.class, aCase);
			List<Chat> chatList = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && !chatList.isEmpty()) {
				responseEntity = new ResponseEntity<List<Chat>>(chatList, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<List<Chat>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<List<Chat>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

//	@RequestMapping(value = "/chat/{chatId}", method = RequestMethod.GET)
//	public @ResponseBody ResponseEntity<Chat> getGroup(@PathVariable("chatId") Long chatId) {
//		ResponseEntity<Chat> responseEntity = null;
//
//		try {
//			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().build();
//			Result result = appFacade.find(chatId, Chat.class, aCase);
//			Chat chat = result.getEntity();
//			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && chat != null) {
//				responseEntity = new ResponseEntity<Chat>(chat, HttpStatus.OK);
//			}
//			responseEntity = new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<Chat>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return responseEntity;
//
//	}
	
	
	
	@RequestMapping(value = "/chat/{chatId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Chat> getGroup(@PathVariable("chatId") Long chatId) {
		ResponseEntity<Chat> responseEntity = null;

		Chat chat = new Chat();
		chat.setId(1);
		chat.setInsertionDate(Calendar.getInstance());
		chat.setPhoto("C:\\caminho");
		chat.setDescription("Grupo Hackatlon");		
		chat.setChatName("Grupo Hackhatlon");
		
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
		
		List<Chat> chatList = new ArrayList<>();
		chatList.add(chat);
		member.setChatList(chatList);
		
		
		Link link = new Link();
		link.setIdMessage("000000001");
		link.setInsertionDate(Calendar.getInstance());
		link.setLink("www.teste.com");
		link.setMember(member);
				
		List<Link> linkList = new ArrayList<>();
		linkList.add(link);
		
		chat.setLinkList(linkList);
		
		Schedule schedule = new Schedule();
		schedule.setDate(Calendar.getInstance());
		schedule.setInsertionDate(Calendar.getInstance());
		schedule.setId(1);
		
		List<Schedule> scheduleList = new ArrayList<>();
		scheduleList.add(schedule);
		
		chat.setScheduleList(scheduleList);
		
		
		
		
		List<Member> memberList = new ArrayList<>();
		memberList.add(member);
		
		chat.setMemberList(memberList);
		
		
		
		
//		
//		try {
//			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().build();
//			Result result = appFacade.find(chatId, Chat.class, aCase);
//			Chat chat = result.getEntity();
//			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && chat != null) {
//				responseEntity = new ResponseEntity<Chat>(chat, HttpStatus.OK);
//			}
//			responseEntity = new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<Chat>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
		responseEntity = new ResponseEntity<Chat>(chat, HttpStatus.OK);
		return responseEntity;

	}
	
	
	// REMOVER Após teste
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getPing() {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello man", HttpStatus.OK);

		return responseEntity;
	}
}
