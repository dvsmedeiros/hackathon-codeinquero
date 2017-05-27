package com.dvsmedeiros.group.api.domain;

import java.util.List;

import com.dvsmedeiros.bce.domain.DomainEntity;



public class Chat extends DomainEntity {
	private List<Link> linkList;
	private List<Member> participantList;
	private String groupName;
	private String photo;

	// Buscar como dever� ser implementado a Localiza��o

	public List<Link> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}

	public List<Member> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Member> participantList) {
		this.participantList = participantList;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
