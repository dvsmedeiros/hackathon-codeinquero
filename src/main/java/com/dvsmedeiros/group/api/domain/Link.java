package com.dvsmedeiros.group.api.domain;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Link extends DomainEntity {
	private String link;
	private String idMessage;
	private Member member;
	
	// Removido por enquanto
	private LinkCategory linkCategory;

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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LinkCategory getLinkCategory() {
		return linkCategory;
	}

	public void setLinkCategory(LinkCategory linkCategory) {
		this.linkCategory = linkCategory;
	}

}
