package com.dvsmedeiros.group.api.domain;

import com.dvsmedeiros.bce.domain.DomainEntity;

public class Profile extends DomainEntity {
	private ProfileType profileType;

	public ProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

}
