package com.dvsmedeiros.group.api.rest.adapter;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.IAdapter;
import com.dvsmedeiros.group.api.domain.Link;
import com.dvsmedeiros.group.api.rest.request.LinkRequest;


@Component
public class LinkAdapter implements IAdapter<LinkRequest, Link>{

	@Override
	public Link adapt(LinkRequest source) {
		Link link = new Link();
		return link;
	}

}
