package com.solidtech.zuulapigatewayserver.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint, Serializable {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {
        logger.info(" authException Message " + authException.getMessage());
        logger.info(" response status" + httpServletResponse.getStatus());
        logger.info(" request Auth Type" + httpServletRequest.getAuthType());


        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized " + authException.getMessage());
    }
}
