package org.example.myspringboot.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.myspringboot.web.service.IntroduceService;
import org.example.myspringboot.web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //必须是 controller 才能被 spring mvc 作为 handler
@Scope("session")
@Slf4j
public class Handlers {
    @Autowired
    ApplicationContext context;

    @Autowired
    private IntroduceService introduceService;

    @RequestMapping("/hello")
    public ResponseEntity<Book> hello() {
        introduceService.sayHello();
        return new ResponseEntity<>(new Book("《水浒装》", 10), HttpStatus.OK);
    }

    @RequestMapping("/hi")
    @ResponseBody
    public Book hi() {
        introduceService.sayHi();
        log.info("handler:{}",this);
        log.info("A:{}",context.getBean(A.class));
        log.info("A:{}",context.getBean(A.class));

        return new Book("《水浒装》", 10);
    }

    @RequestMapping("/exc")
    @ResponseBody
    public Book exc() {
        log.debug("enter exc handler");
        int a = 1 / 0;
        return new Book("《水浒装》", 10);
    }

    @RequestMapping("/get-str")
    @ResponseBody
    public String getStr(){
        return "str";
    }
}
