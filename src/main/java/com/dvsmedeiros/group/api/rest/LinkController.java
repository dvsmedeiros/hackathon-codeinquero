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
import org.thymeleaf.util.ListUtils;

import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.core.controller.impl.Navigator;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.group.api.controller.BaseController;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Link;

@Controller
public class LinkController extends BaseController{
	
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Link> appFacade;
	
	
	@Autowired
	@Qualifier("navigator")
	private Navigator<Link> navigator;
	
	@RequestMapping(value = "/chat/{chatId}/link", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Link>> getAllGroupContents(@PathVariable("chatId") Long chatId) {
		ResponseEntity<List<Link>> responseEntity = null;		
		
		
		try {
			Filter<Link> filter = new Filter<>(Link.class);
			Chat chat = new Chat();
			chat.setId(chatId);
			filter.getEntity().setChat(chat);			
			
			BusinessCase<Link> aCase = new BusinessCaseBuilder<Link>().build();
			Result result = appFacade.find(filter, aCase);
			List<Link> linkList = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && linkList != null) {
				responseEntity = new ResponseEntity<List<Link>>(linkList, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<List<Link>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<List<Link>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/chat/{chatId}/link/{linkId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Link> getContent(@PathVariable("chatId") Long chatId, @PathVariable("linkId") Long linkId) {
		ResponseEntity<Link> responseEntity = null;

		try {
			Filter<Link> filter = new Filter<>(Link.class);
			
			Chat chat = new Chat();
			chat.setId(chatId);
			
			filter.getEntity().setId(linkId);
			filter.getEntity().setChat(chat);
			
			// CRIAR CONSULTA PELO FILTRO
			BusinessCase<Link> aCase = new BusinessCaseBuilder<Link>().build();
			Result result = appFacade.find(filter, aCase);
			List<Link> linkList = result.getEntities();			
			
			
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && !ListUtils.isEmpty(linkList)) {
				Link link = linkList.get(0);
				responseEntity = new ResponseEntity<Link>(link, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<Link>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Link>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}