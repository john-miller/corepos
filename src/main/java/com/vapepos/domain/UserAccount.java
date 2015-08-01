package com.vapepos.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
public class UserAccount implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany
	private Collection<? extends GrantedAuthority> authorities;
	
	@Column(name = "ACCOUNT_NON_EXPIRED")
	private boolean accountNonExpired;
	
	@Column(name = "ACCOUNT_NON_LOCKED")
	private boolean accountNonLocked;
	
	@Column(name = "CREDENTIALS_NON_EXPIRED")
	private boolean credentialsNonExpired;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
