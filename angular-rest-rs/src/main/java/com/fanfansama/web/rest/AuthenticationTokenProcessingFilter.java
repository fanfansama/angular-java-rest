package com.fanfansama.web.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;

import com.fanfansama.web.rest.util.CallMatchHttpHeader;
import com.fanfansama.web.rest.util.ResponseUtil;
import com.fanfansama.web.rest.util.SecurityErrorCode;
import com.fanfansama.web.rest.util.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import static com.fanfansama.web.rest.util.ResponseUtil.initResponseHttpHeaders;
import static com.fanfansama.web.rest.util.TokenUtils.validateToken;

@Slf4j
@Component
public class AuthenticationTokenProcessingFilter extends GenericFilterBean
{

	@Autowired
	private UserDetailsService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException
	{
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);
		HttpServletResponse httpResponse = this.getAsHttpResponse(response);

        String path = httpRequest.getRequestURI();

        boolean checkToken = !HttpMethod.OPTIONS.equals(httpRequest.getMethod()) &&
                !path.endsWith("authenticate") &&
                !path.endsWith("logout") ;

        if(checkToken){
            String authToken = this.extractAuthTokenFromRequest(httpRequest);
            if(authToken == null){
                initResponseHttpHeaders(httpResponse, SecurityErrorCode.TOKEN_INVALID, "Token missing");
                return;
            }
            String userName = TokenUtils.getUserNameFromToken(authToken);
            logger.debug("authToken :"+authToken);
            logger.debug("userName :"+userName);
            if (userName != null) {

                UserDetails userDetails = this.userService.loadUserByUsername(userName);

                if (validateToken(authToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    logger.warn("no valid token " + authToken);
                    initResponseHttpHeaders(httpResponse, SecurityErrorCode.TOKEN_INVALID, "Vous avez été déconnecté. Re-saisissez vos login et mot de passe.");
                    return;
                }
            } else {
                initResponseHttpHeaders(httpResponse, SecurityErrorCode.USER_UNAUTHORIZED, "Saisissez vos login et mot de passe.");
                return;
            }



        }
        chain.doFilter(request, response);
	}


	private HttpServletRequest getAsHttpRequest(ServletRequest request)
	{
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP request");
		}

		return (HttpServletRequest) request;
	}

    private HttpServletResponse getAsHttpResponse(ServletResponse response)
	{
		if (!(response instanceof HttpServletResponse)) {
			throw new RuntimeException("Expecting an HTTP response");
		}

		return (HttpServletResponse) response;
	}


	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest)
	{
		/* Get token from header */
		String authToken = httpRequest.getHeader(CallMatchHttpHeader.AUTHENTICATION_TOKEN.getValue());

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}
}
