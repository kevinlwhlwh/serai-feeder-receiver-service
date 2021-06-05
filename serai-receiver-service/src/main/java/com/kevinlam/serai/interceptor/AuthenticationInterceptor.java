package com.kevinlam.serai.interceptor;


import com.kevinlam.serai.controller.ReceiverApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ReceiverApiController.class);

    private static final String TOKEN_HEADER = "X-Auth-Token";
    @Value("${authentication.token:invalid}")
    private String token;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("Request X-Auth-Token: {}", request.getHeader(TOKEN_HEADER));
        log.debug("Local X-Auth-Token: {}", token);
        if(null != request.getHeader(TOKEN_HEADER) && request.getHeader(TOKEN_HEADER).equals(token)){
            return true;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not from feeder");
        return false;
    }
}
