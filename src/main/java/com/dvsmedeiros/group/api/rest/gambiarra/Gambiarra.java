package com.dvsmedeiros.group.api.rest.gambiarra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.group.api.domain.Chat;

@Component
public class Gambiarra {

	public List<Chat> makeTheMagic(List temp) {
		List<Chat> chatList = new ArrayList<>();
		for (Object o : temp) {
			if (o instanceof Chat) {
				chatList.add((Chat) o);
			}
		}
		return chatList;
	}

}
