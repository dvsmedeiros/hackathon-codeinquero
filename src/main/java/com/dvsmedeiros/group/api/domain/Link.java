package com.dvsmedeiros.group.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainEntity;

@Component
@Entity
@Table(name = "CONTENT_LINKS")
public class Link extends DomainEntity {
	
	private String link;
	private String idMessage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Member member;
	
	@ManyToOne(cascade = CascadeType.ALL)
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
