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
import com.dvsmedeiros.group.api.domain.Chat;

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
			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().withName("CHAT_FIND_ALL").build();
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

	@RequestMapping(value = "/chat/{chatId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Chat> getGroup(@PathVariable("chatId") Long chatId) {
		ResponseEntity<Chat> responseEntity = null;

		try {
			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().withName("FIND_BY_ID").build();
			Result result = appFacade.find(chatId, Chat.class, aCase);
			Chat chat = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && chat != null) {
				responseEntity = new ResponseEntity<Chat>(chat, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Chat>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	

	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getPing() {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello man", HttpStatus.INTERNAL_SERVER_ERROR);

		return responseEntity;
	}
}