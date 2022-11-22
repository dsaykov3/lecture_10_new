package com.progress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class AutowiredExample {

    @Autowired
    HelloBean helloBean;

    @Autowired
    @Qualifier("wiredTransferService")
    TransferService transferService;

    @Autowired
    public AutowiredExample(HelloBean helloBean, @Qualifier("wiredTransferService") TransferService transferService) {
        this.helloBean = helloBean;
        this.transferService = transferService;
    }

    public AutowiredExample() {
    }

    public String getMessage() {
        helloBean.setMessage("Hello world from Autowired");
        transferService.transfer(33);
        return helloBean.getMessage();
    }
}
