package com.progress;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ResourseExample {
    private HelloBean helloBean;

    @Resource(name="helloBean")
    public void setMovieFinder(HelloBean helloBean) {
        this.helloBean = helloBean;
    }

    public HelloBean getHelloBean() {
        return helloBean;
    }
}
