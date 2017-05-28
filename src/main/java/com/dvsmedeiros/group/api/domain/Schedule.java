package com.dvsmedeiros.group.api.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainEntity;

@Component
@Entity
@Table(name = "SCHEDULES")
public class Schedule extends DomainEntity {
	
	private Calendar date;

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
