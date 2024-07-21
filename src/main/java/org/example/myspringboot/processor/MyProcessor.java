package org.example.myspringboot.processor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
@Data
@Slf4j
public class MyProcessor implements BeanPostProcessor {
//    @Autowired
    private A a;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (a != null) {
            log.info("dependency already exist");
        }
        if(bean instanceof A){
            log.info("A enter");
        }else if(bean instanceof B){
            log.info("B enter");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
