package com.dvsmedeiros.group.api.controller.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.repository.GenericRepository;
import com.dvsmedeiros.group.api.domain.Chat;
import com.dvsmedeiros.group.api.domain.Member;

@Component
public interface MemberRepository extends GenericRepository<Member> {
	public List<Member> findByMemberId(Integer memberId);
	public List<Member> findByChatList(List<Chat> chatList);

}
