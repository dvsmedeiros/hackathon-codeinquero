package com.dvsmedeiros.group.api.domain.filter;

import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Member;

public class MemberFilter extends Filter<Member> {
	private Long chatId;
	private Long memberId;

	public MemberFilter() {
		super(Member.class);
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

}
