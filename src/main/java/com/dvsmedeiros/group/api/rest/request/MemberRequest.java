package com.dvsmedeiros.group.api.rest.request;

public class MemberRequest {
	private Integer id;
	private String first_name;
	private String last_name;
	private Integer chatId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

}
