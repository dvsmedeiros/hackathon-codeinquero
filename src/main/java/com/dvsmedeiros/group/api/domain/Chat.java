package com.dvsmedeiros.group.api.domain;

import java.util.List;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Chat extends DomainEntity {
	private List<Link> linkList;
	private List<Member> memberList;
	private String chatName;
	private String photo;

	public List<Link> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	// Buscar como dever� ser implementado a Localiza��o

}
