package com.dvsmedeiros.group.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainEntity;

@Component
@Entity
@Table(name = "CONTENTS")
public class Content extends DomainEntity {
	// O idMessage não é único, ele deve ser associado ao chatId do Chat
	private Integer idMessage;

	private Integer aLike;

	private Integer dislike;

	@ManyToOne(cascade = CascadeType.ALL)
	private Member member;

	@ManyToOne(cascade = CascadeType.ALL)
	private Chat chat;

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public Integer getaLike() {
		return aLike;
	}

	public void setaLike(Integer aLike) {
		this.aLike = aLike;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public Integer getALike() {
		return aLike;
	}

	public void setALike(Integer aLike) {
		this.aLike = aLike;
	}
	
}
