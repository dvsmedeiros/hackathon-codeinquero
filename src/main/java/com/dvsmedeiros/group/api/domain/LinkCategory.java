package com.dvsmedeiros.group.api.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "LINK_CATEGORIES")
public class LinkCategory extends Category{

}
