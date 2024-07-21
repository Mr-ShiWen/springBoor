package org.example.myspringboot;

import com.example.mystarter.introduce.HelloIntroduce;
import com.example.mystarter.introduce.HiIntroduce;
import com.example.mystarter.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.example.myspringboot.beanFinder.BeanFinder;
import org.example.myspringboot.config.BookConfig;
import org.example.myspringboot.config.MyProfile;
import org.example.myspringboot.config.StudentConfig;
import org.example.myspringboot.config.test.ConfigTest;
import org.example.myspringboot.config.test.ConfigTest1;
import org.example.myspringboot.mybatis.MybatisTest;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
@MapperScans(value = {
        @MapperScan("org.example.myspringboot.mybatis.mapper.annotation"),
        @MapperScan(value = "org.example.myspringboot.mybatis.mapper.dynamic"),
        @MapperScan(value = "org.example.myspringboot.mybatis.mapper.xml")
})
public class MySpringBootApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);
//
//        BeanFinder beanFinder = context.getBean(BeanFinder.class);
//        beanFinder.find();
//
//        MybatisTest mybatisTest = context.getBean(MybatisTest.class);
//        mybatisTest.testTransaction();
//
//        new Scanner(System.in).next();
    }

    private static void testMapper(ConfigurableApplicationContext context) {
        MybatisTest mybatisTest = context.getBean(MybatisTest.class);

        mybatisTest.testXmlUserMappper();
        mybatisTest.testAnnotationUserMapper();
        mybatisTest.testDynamicUserMappper();
    }

    public static void testConfig(ConfigurableApplicationContext context) {
        MyProfile profile = context.getBean(ConfigTest.class).getMyProfile();
        MyProfile profile1 = context.getBean(ConfigTest1.class).getMyProfile();

        log.debug("configTest.MyProfile:{}", profile);
        log.debug("configTest.MyProfile:{}", profile1);
        log.debug("student name:{}", context.getBean(ConfigTest.class).getStudentName());
    }

    public void testAutoLoad(ConfigurableApplicationContext context) {
        log.debug("----- starter ------\n");
        context.getBean(HiIntroduce.class).sayHi();
        context.getBean(HelloIntroduce.class).sayHello();
        context.getBean(HelloService.class).doHello();
        log.debug("----- starter end ------\n");

        log.debug("student config:{}", context.getBean(StudentConfig.class).toString());
        log.debug("student config:{}", context.getBean(BookConfig.class).toString());
    }

}
