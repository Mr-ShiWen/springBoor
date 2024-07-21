package org.example.myspringboot.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IntroduceService {

    public void sayHello(){
        log.debug("hello world");
    }

    public void sayHi(){
        log.debug("hi world");
    }
}
