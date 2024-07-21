package org.example.myspringboot.config.test;

import lombok.Data;
import org.example.myspringboot.config.MyProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConfigTest1 {
    @Autowired
    private MyProfile myProfile;
}
