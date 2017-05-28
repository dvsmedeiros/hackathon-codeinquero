package com.dvsmedeiros.group.api.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainEntity;

@Component
@Entity
@Table(name = "MEMBERS")
public class Member extends DomainEntity {
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "MEMBER_ID")
	private List<Chat> chatList;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;	
	
	// Adicionar lista de arquivos -- Verificar como receber do node a lista de arquivos
	// Criar classe de tipo de arquivo contendo audio/video ...

	public List<Chat> getChatList() {
		return chatList;
	}

	public void setChatList(List<Chat> chatList) {
		this.chatList = chatList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
