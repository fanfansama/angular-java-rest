package com.fanfansama.web.transfer;

import lombok.Getter;

import java.util.Map;

@Getter
public class UserTransfer
{

	private final String name;

	private final Map<String, Boolean> roles;


	public UserTransfer(String userName, Map<String, Boolean> roles)
	{
		this.name = userName;
		this.roles = roles;
	}

}