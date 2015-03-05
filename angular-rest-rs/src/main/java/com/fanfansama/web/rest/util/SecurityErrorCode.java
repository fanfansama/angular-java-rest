package com.fanfansama.web.rest.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.fanfansama.web.rest.util.WebStatusCode.FORBIDDEN;
import static com.fanfansama.web.rest.util.WebStatusCode.INTERNAL_SERVER_ERROR;
import static com.fanfansama.web.rest.util.WebStatusCode.UNAUTHORIZED;

/**
 * Created by francois on 05/03/15.
 */
@AllArgsConstructor
public enum SecurityErrorCode {

    INTERNAL_ERROR(INTERNAL_SERVER_ERROR, null),
    LOGIN_PASSWORD_INCORRECT(UNAUTHORIZED, null),
    USER_UNAUTHORIZED(UNAUTHORIZED, "USR_KO"),
    ACCOUNT_EXPIRED(UNAUTHORIZED, "USR_KO"),
    TOKEN_INVALID(UNAUTHORIZED, "USR_KO"),
    SRV_ACCESS_DENIED(FORBIDDEN, null);

    @Getter
    private WebStatusCode webStatusCode;

    @Getter
    private String code;


}
