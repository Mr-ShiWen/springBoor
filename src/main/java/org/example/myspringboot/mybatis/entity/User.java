package org.example.myspringboot.mybatis.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String userName;

    private Integer age;

    private Byte sex;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String userName, Integer age, Byte sex, Date birthday) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }
}