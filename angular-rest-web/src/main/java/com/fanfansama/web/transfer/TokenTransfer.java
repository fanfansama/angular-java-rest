package com.fanfansama.web.transfer;

import lombok.Getter;

@Getter
public class TokenTransfer
{
	private final String token;

	public TokenTransfer(String token)
	{
		this.token = token;
	}

}