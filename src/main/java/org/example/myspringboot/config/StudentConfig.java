package org.example.myspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("myStudentConfig")
@ConfigurationProperties("student")
@Data
public class StudentConfig {
    private String name;
    private int age;
}
