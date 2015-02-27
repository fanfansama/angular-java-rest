package com.fanfansama.dal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER")
public class User {
	
	@Id
    @GeneratedValue
	private Long id;

	@Column(unique = true, length = 16, nullable = false)
	private String name;

	@Column(length = 80, nullable = false)
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles = new HashSet<String>();

	public User(String name, String passwordHash) {
		this.name = name;
		this.password = passwordHash;
	}
	public Long getId(){
		return id;
	}
	public String getName(){return name;}
	public String getPassword(){return password;}
	public Set<String> getRoles(){return roles;}

	public void addRole(String role)
	{
		this.roles.add(role);
	}

     public User(){}
}

