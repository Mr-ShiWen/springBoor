package org.example.myspringboot.config;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Data
@ConfigurationProperties("my-profile")
@Validated
public class MyProfile {

    @NotEmpty
    String name;

    @Email
    @NotEmpty
    String email;
}
