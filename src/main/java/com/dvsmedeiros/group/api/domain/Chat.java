package com.dvsmedeiros.group.api.domain;

import java.util.List;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Chat extends DomainEntity {
	private List<Link> linkList;
	private List<Member> memberList;
	private String chatName;
	private String photo;
	private String description;
	private List<Schedule> scheduleList;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	// Buscar como dever� ser implementado a Localiza��o

}
