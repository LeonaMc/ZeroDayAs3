package com.zeroday.auth.appsecurity;

import com.zeroday.auth.service.UserService;
import com.zeroday.auth.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService = new UserServiceImpl();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            request.getSession(false).setMaxInactiveInterval(10);
        } else {
            request.getSession(false).setMaxInactiveInterval(120);
        }
        try {
            handle(request, response, authentication);
            cleanAuthAttribute(request);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IllegalAccessException, IOException {
        User user = (User) authentication.getPrincipal();
        String targetURL = determineURL(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("userName", user.getUsername());
        // add more attributes
        if (response.isCommitted()) {
            System.out.println("Response has already been committed. Unable to redirect to " + targetURL);
        }
        redirectStrategy.sendRedirect(request, response, targetURL);
    }

    protected String determineURL(Authentication authentication) throws IllegalAccessException {
        return "/perform-login";
    }

    protected void cleanAuthAttribute(HttpServletRequest request) {
        HttpSession session = request.getSession(Boolean.FALSE);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
