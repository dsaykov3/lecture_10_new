package com.progress;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Calendar;
import java.util.Date;

public class HelloBean {
    public HelloBean(String message) {
        this.message = message;
    }

    public HelloBean() {
    }
    @Value("${catalog.name}")
    private String messageValue;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageValue() {
        return messageValue;
    }



    @PostConstruct
    public void populateResourses() {
        System.out.println("Post construct is invoked");

    }


    @PreDestroy
    public void clearResources() {
        System.out.println("Pre destroy is invoked");
    }
}
