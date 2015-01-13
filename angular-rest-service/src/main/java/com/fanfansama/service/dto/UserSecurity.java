package com.fanfansama.service.dto;

import com.fanfansama.dal.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fanfan on 12/01/2015.
 */
@Getter
@Setter
public class UserSecurity implements UserDetails {

    private Long id;

    private String name;

    private String password;

    private Set<String> roles = new HashSet<>();

    public UserSecurity(final User pUser){
		if(pUser != null){
			id = pUser.getId();
			name = pUser.getName();
			password = pUser.getPassword();
			roles = pUser.getRoles();
		}
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		Set<String> roles = this.getRoles();

		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}

	public String getPassword(){
		return password;
	}

	public Set<String> getRoles(){
		return roles;
	}
	
	@Override
	public String getUsername()
	{
		return this.name;
	}


	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}


	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}


	@Override
	public boolean isEnabled()
	{
		return true;
	}

}

