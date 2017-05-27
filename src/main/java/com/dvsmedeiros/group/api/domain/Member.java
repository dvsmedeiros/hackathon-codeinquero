package com.dvsmedeiros.group.api.domain;

import java.util.List;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Member extends DomainEntity {
	private List<Chat> grupoList;
	private User user;	
	// Adicionar lista de arquivos -- Verificar como receber do node a lista de arquivos
	// Criar classe de tipo de arquivo contendo audio/video ...

	public List<Chat> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Chat> grupoList) {
		this.grupoList = grupoList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
