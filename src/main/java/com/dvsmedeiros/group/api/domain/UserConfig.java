package com.dvsmedeiros.group.api.domain;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class UserConfig extends DomainEntity {
	private Profile profile;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}

