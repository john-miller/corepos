package com.vapepos.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ROLES")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Override
	public String getAuthority() {
		return name;
	}

}
