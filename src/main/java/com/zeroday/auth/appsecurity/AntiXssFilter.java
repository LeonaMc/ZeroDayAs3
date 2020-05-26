package com.zeroday.auth.appsecurity;

import org.springframework.web.util.HtmlUtils;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AntiXssFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialised");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String userInput = servletRequest.getParameter("param");
//        if (userInput != null && !userInput.equalsIgnoreCase(HtmlUtils.htmlEscape(userInput)))
//            throw new RuntimeException();
        filterChain.doFilter(new XSSRequestWrapper((HttpServletRequest) servletRequest), servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}

