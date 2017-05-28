package com.dvsmedeiros.group.api.rest;

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
import com.dvsmedeiros.group.api.domain.Member;
import com.dvsmedeiros.group.api.domain.filter.MemberFilter;

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
			MemberFilter filter = new MemberFilter();
			filter.setChatId(chatId);
			
			BusinessCase<Member> aCase = new BusinessCaseBuilder<Member>().withName("FIND_CHAT_MEMBERS").build();
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
	public @ResponseBody ResponseEntity<Member> getMember(@PathVariable("memberId") Long chatId) {
		ResponseEntity<Member> responseEntity = null;		
		
		try {
			MemberFilter filter = new MemberFilter();
			filter.setChatId(chatId);
			
			BusinessCase<Member> aCase = new BusinessCaseBuilder<Member>().withName("FIND_CHAT_MEMBER_BY_ID").build();
			Result result = appFacade.find(filter, aCase);
			Member member = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && member != null) {
				responseEntity = new ResponseEntity<Member>(member, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
		
		
		
	}
	
	
	
	
	
}
