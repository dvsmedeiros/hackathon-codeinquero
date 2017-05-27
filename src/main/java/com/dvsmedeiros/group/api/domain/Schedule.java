package com.dvsmedeiros.group.api.domain;

import java.util.Calendar;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Schedule extends DomainEntity {
	private Calendar date;
	// Localiza��o

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
