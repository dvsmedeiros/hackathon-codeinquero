package com.dvsmedeiros.group.api.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainEntity;

@Component
@Entity
@Table(name = "CONTENTS")
public class Content extends DomainEntity {

}
