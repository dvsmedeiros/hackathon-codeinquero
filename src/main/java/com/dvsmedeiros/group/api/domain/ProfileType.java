package com.dvsmedeiros.group.api.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainSpecificEntity;

@Component
@Entity
@Table(name = "PROFILE_TYPES")
public class ProfileType extends DomainSpecificEntity{

}
