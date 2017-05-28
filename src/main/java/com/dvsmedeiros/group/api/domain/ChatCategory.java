package com.dvsmedeiros.group.api.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CHAT_CATEGORIES")
public class ChatCategory extends Category{

}
