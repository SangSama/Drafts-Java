package com.news.listening;

import com.news.autowire.BeanFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        BeanFactory beanFactory = new BeanFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
