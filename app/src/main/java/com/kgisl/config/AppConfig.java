package com.kgisl.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("1");
        return new Class[] { WebConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("2");

        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("3");

        return new String[] { "/" };
    }
}
