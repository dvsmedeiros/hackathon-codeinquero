package com.dvsmedeiros.group.api.controller.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.repository.GenericRepository;
import com.dvsmedeiros.group.api.domain.Link;

@Component
public interface LinkRepository extends GenericRepository<Link> {
	public List<Link> findByChatId(Integer idMessage, Integer chatId);

}
