package org.example.myspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("myBookConfig")
@ConfigurationProperties("book")
public class BookConfig {
    private String name;
    private int price;
}
