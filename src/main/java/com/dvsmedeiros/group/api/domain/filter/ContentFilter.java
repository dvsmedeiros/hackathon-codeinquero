package com.dvsmedeiros.group.api.domain.filter;

import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.group.api.domain.Content;

public class ContentFilter extends Filter<Content>{

	public ContentFilter(Class<? extends Content> clazz) {
		super(clazz);
	}

}
