package com.dvsmedeiros.group.api.controller.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.repository.GenericRepository;
import com.dvsmedeiros.group.api.domain.Chat;

@Component
public interface ChatRepository extends GenericRepository<Chat> {
	public List<Chat> findByChatId(Integer chatId);

}
