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
import org.thymeleaf.util.ListUtils;

import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.core.controller.impl.Navigator;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.group.api.controller.BaseController;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Member;
import com.dvsmedeiros.group.api.rest.adapter.MemberAdapter;
import com.dvsmedeiros.group.api.rest.gambiarra.Gambiarra;
import com.dvsmedeiros.group.api.rest.request.MemberRequest;

@Controller
public class MemberController extends BaseController {
	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Member> appFacade;

	@Autowired
	@Qualifier("applicationFacade")
	private ApplicationFacade<Chat> chatFacade;

	@Autowired
	@Qualifier("navigator")
	private Navigator<Member> navigator;

	@Autowired
	@Qualifier("memberAdapter")
	private MemberAdapter memberAdapter;

	@Autowired
	private Gambiarra gambiarra;

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
			} else {
				responseEntity = new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<List<Member>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@RequestMapping(value = "/chat/{chatId}/member/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Member> getMember(@PathVariable("chatId") Long chatId,
			@PathVariable("memberId") Long memberId) {
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
			} else {
				responseEntity = new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			responseEntity = new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;

	}

	@ResponseBody
	@RequestMapping(value = "/member", method = RequestMethod.DELETE)
	public ResponseEntity<Member> deleteMember(@RequestBody MemberRequest memberRequest) {
		ResponseEntity<Member> responseEntity = null;

		try {
			Member member = memberAdapter.adapt(memberRequest);

			Filter<Member> memberFilter = new Filter<>(Member.class);
			memberFilter.getEntity().setMemberId(memberRequest.getId());

			List<Member> memberList = appFacade.find(memberFilter, new BusinessCaseBuilder<Member>().build())
					.getEntities();

			if (!ListUtils.isEmpty(memberList)) {
				member = memberList.get(0);

				Filter<Chat> filter = new Filter<>(Chat.class);
				filter.getEntity().setChatId(memberRequest.getChatId());

				List temp = chatFacade.find(filter, new BusinessCaseBuilder<Chat>().build()).getEntities();
				List<Chat> chatList = gambiarra.makeTheMagic(temp);

				if (!ListUtils.isEmpty(chatList)) {
					Chat chat = chatList.get(0);
					if (chat.getMemberList() != null) {
						chat.getMemberList().remove(member);
						chatFacade.update(chat, new BusinessCaseBuilder<Chat>().build());
					}
				}
			}
			responseEntity = new ResponseEntity<Member>(HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;

	}

	@ResponseBody
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public ResponseEntity<Member> postMember(@RequestBody MemberRequest memberRequest) {
		ResponseEntity<Member> responseEntity;

		try {
			Member member = memberAdapter.adapt(memberRequest);
			BusinessCase<Member> aCase = new BusinessCaseBuilder<Member>().withName("SAVE_MEMBER").build();
			navigator.run(member, aCase);

			Filter<Chat> filter = new Filter<>(Chat.class);
			filter.getEntity().setChatId(memberRequest.getChatId());

			List temp = chatFacade.find(filter, new BusinessCaseBuilder<Chat>().build()).getEntities();
			List<Chat> chatList = gambiarra.makeTheMagic(temp);

			if (!ListUtils.isEmpty(chatList)) {
				Chat chat = chatList.get(0);
				if (chat.getMemberList() == null) {
					chat.setMemberList(new ArrayList<>());
				}
				chat.getMemberList().add(member);
				chatFacade.update(chat, new BusinessCaseBuilder<Chat>().build());
			} else {
				responseEntity = new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			responseEntity = new ResponseEntity<Member>(HttpStatus.OK);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		responseEntity = new ResponseEntity<Member>(HttpStatus.OK);

		return responseEntity;

	}
	
	@RequestMapping("/bla")
	public void bla(){
		
		BusinessCase<Member> aCase = new BusinessCaseBuilder<Member>().withName("SAVE_MEMBER").build();
		navigator.run(new Member(), aCase);
	}
	
}
