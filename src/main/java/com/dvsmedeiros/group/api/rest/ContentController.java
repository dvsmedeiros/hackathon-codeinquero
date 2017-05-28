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
import com.dvsmedeiros.group.api.domain.Content;
import com.dvsmedeiros.group.api.domain.filter.ContentFilter;

@Controller
public class ContentController extends BaseController{
	
	
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Content> appFacade;
	
	
	@Autowired
	@Qualifier("navigator")
	private Navigator<Content> navigator;
	
	
	
	
	@RequestMapping(value = "/chat/{chatId}/content", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Content>> getAllGroupContents(@PathVariable("chatId") Long chatId) {
		ResponseEntity<List<Content>> responseEntity = null;		
		
		
		try {
			ContentFilter filter = new ContentFilter();
			filter.setChatId(chatId);
			
			BusinessCase<Content> aCase = new BusinessCaseBuilder<Content>().withName("FIND_CHAT_CONTENT").build();
			Result result = appFacade.find(filter, aCase);
			List<Content> contentList = result.getEntities();
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && contentList != null) {
				responseEntity = new ResponseEntity<List<Content>>(contentList, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<List<Content>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<List<Content>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/chat/{chatId}/content/{contentId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Content> getContent(@PathVariable("chatId") Long chatId, @PathVariable("contentId") Long contentId) {
		ResponseEntity<Content> responseEntity = null;

		try {
			ContentFilter filter = new ContentFilter();
			filter.setChatId(chatId);
			filter.setContentId(contentId);
			
			// CRIAR CONSULTA PELO FILTRO
			BusinessCase<Content> aCase = new BusinessCaseBuilder<Content>().withName("FIND_CHAT_CONTENT_BY_ID").build();
			Result result = appFacade.find(filter, aCase);
			Content content = result.getEntity();			
			
			if (!aCase.isSuspendExecution() && !aCase.getResult().hasError() && content != null) {
				responseEntity = new ResponseEntity<Content>(content, HttpStatus.OK);
			}
			responseEntity = new ResponseEntity<Content>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Content>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	
	



}
