package com.fanfansama.web.rest.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CallMatchHttpHeader {

	/**
     * Entête HTTP précisant le jeton de session attribué à un utilisateur connecté.
	 */
	AUTHENTICATION_TOKEN("X-Auth-Token");

	@Getter
	private String value;

}
