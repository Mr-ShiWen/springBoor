package org.example.myspringboot.web.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import javax.management.ConstructorParameters;

@Data
@Component
@ConditionalOnClass(String.class)
public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Book() {
    }
}
