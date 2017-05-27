package com.dvsmedeiros.group.api.domain.filter;

import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Content;

public class ContentFilter extends Filter<Content> {

	private Long chatId;
	private Long contentId;

	public ContentFilter() {
		super(Content.class);
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long idChat) {
		this.chatId = idChat;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long idContent) {
		this.contentId = idContent;
	}

}
