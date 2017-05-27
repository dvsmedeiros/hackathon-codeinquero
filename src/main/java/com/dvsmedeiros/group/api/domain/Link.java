package com.dvsmedeiros.group.api.domain;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Link extends DomainEntity {
	private String link;
	private String idMessage;
	private Member participant;
	private Category category;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public Member getParticipant() {
		return participant;
	}

	public void setParticipant(Member participant) {
		this.participant = participant;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
