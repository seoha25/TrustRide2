package com.fastcampus.trustRide.auth.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String email = request.getParameter("userEmail");
        String contextPath = request.getContextPath();

        String loginType = "personal";
        if (email != null && email.startsWith("admin:")) {
            loginType = "admin";
        }

        response.sendRedirect(contextPath + "/login.do?error=true&loginType=" + loginType);
    }
}
