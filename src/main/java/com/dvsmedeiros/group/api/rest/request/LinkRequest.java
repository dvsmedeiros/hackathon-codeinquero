package com.dvsmedeiros.group.api.rest.request;

public class LinkRequest {
	private Integer chatId;
	private String link;
	private Integer like;
	private Integer dislike;
	private MemberRequest member;
	private Integer messageId;

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public MemberRequest getMember() {
		return member;
	}

	public void setMember(MemberRequest member) {
		this.member = member;
	}

	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

}
