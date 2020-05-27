package com.zeroday.auth.appsecurity;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        context.getSessionCookieConfig().setSecure(true);
        context.getSessionCookieConfig().setHttpOnly(true);
    }
}