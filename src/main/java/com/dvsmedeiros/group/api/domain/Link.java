package com.dvsmedeiros.group.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CONTENT_LINKS")
public class Link extends Content {

	private String aLink;

	@ManyToOne(cascade = CascadeType.ALL)
	private LinkCategory linkCategory;

	public String getaLink() {
		return aLink;
	}

	public void setaLink(String aLink) {
		this.aLink = aLink;
	}

	public LinkCategory getLinkCategory() {
		return linkCategory;
	}

	public void setLinkCategory(LinkCategory linkCategory) {
		this.linkCategory = linkCategory;
	}

}
