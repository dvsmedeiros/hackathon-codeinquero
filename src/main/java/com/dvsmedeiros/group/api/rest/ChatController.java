package com.dvsmedeiros.group.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.dvsmedeiros.group.api.rest.adapter.ChatAdapter;
import com.dvsmedeiros.group.api.rest.request.ChatRequest;

@Controller
public class ChatController extends BaseController {

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Chat> appFacade;

	@Autowired
	@Qualifier("navigator")
	private Navigator<Chat> navigator;
	
	@Autowired
	@Qualifier("chatAdapter")
	private ChatAdapter chatAdapter;

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Chat>> getAllGroups() {
		ResponseEntity<List<Chat>> responseEntity = null;

		try {
			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().build();
			Result result = appFacade.findAll(Chat.class, aCase);
			List temp = result.getEntities();
			
			List<Chat> chatList = new ArrayList<>();
			for(Object o : temp){
				if(o instanceof Chat ){
					chatList.add((Chat) o);
				}
			}
			
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && !chatList.isEmpty()) {
				responseEntity = new ResponseEntity<List<Chat>>(chatList, HttpStatus.OK);
			}else{				
				responseEntity = new ResponseEntity<List<Chat>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<List<Chat>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@RequestMapping(value = "/chat/{chatId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Chat> getGroup(@PathVariable("chatId") Long chatId) {
		ResponseEntity<Chat> responseEntity = null;

		try {
			BusinessCase<Chat> aCase = new BusinessCaseBuilder<Chat>().build();
			Result result = appFacade.find(chatId, Chat.class, aCase);
			Chat chat = result.getEntity();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && chat != null) {
				responseEntity = new ResponseEntity<Chat>(chat, HttpStatus.OK);
			}else{
				responseEntity = new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Chat>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;

	}	
	
	@ResponseBody
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	public ResponseEntity<Chat> postChat(@RequestBody ChatRequest chatRequest) {
		ResponseEntity<Chat> responseEntity;
		
		try {
			Chat chat = chatAdapter.adapt(chatRequest);
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
	
	
}
