package com.dvsmedeiros.group.api.rest;

import java.util.ArrayList;
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
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.group.api.controller.BaseController;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Member;

@Controller
public class MemberController extends BaseController{
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Member> appFacade;
	
	
	@Autowired
	@Qualifier("navigator")
	private Navigator<Member> navigator;
	
	
	@RequestMapping(value = "/chat/{chatId}/members", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Member>> getAllGroupMembers(@PathVariable("chatId") Long chatId) {
		ResponseEntity<List<Member>> responseEntity = null;		
		
		
		try {
			Filter<Member> filter = new Filter<>(Member.class);
			
			Chat chat = new Chat();
			chat.setId(chatId);
			
			List<Chat> chatList = new ArrayList<>();
			
			filter.getEntity().setChatList(chatList);
			
			BusinessCase<Member> aCase = new BusinessCaseBuilder<Member>().build();
			Result result = appFacade.find(filter, aCase);
			List<Member> memberList = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && memberList != null) {
				responseEntity = new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<List<Member>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/chat/{chatId}/member/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Member> getMember(@PathVariable("chatId") Long chatId, @PathVariable("memberId") Long memberId) {
		ResponseEntity<Member> responseEntity = null;		
		
		try {
			Filter<Member> filter = new Filter<>(Member.class);
			
			Chat chat = new Chat();
			chat.setId(chatId);
			
			List<Chat> chatList = new ArrayList<>();
			filter.getEntity().setId(memberId);
			filter.getEntity().setChatList(chatList);
			
			
			BusinessCase<Member> aCase = new BusinessCaseBuilder<Member>().build();
			Result result = appFacade.find(filter, aCase);
			List<Member> memberList = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && memberList != null) {
				Member member = memberList.get(0); // Melhorar isso				
				responseEntity = new ResponseEntity<Member>(member, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
		
		
		
	}
	
	
	
	
	
}
