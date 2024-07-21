package org.example.myspringboot.mybatis.mapper.annotation;

import org.apache.ibatis.jdbc.SQL;
import org.example.myspringboot.mybatis.entity.User;

public class UserSqlProvider {
    public String insertSelective(User row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (row.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (row.getAge() != null) {
            sql.VALUES("age", "#{age,jdbcType=INTEGER}");
        }
        
        if (row.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=TINYINT}");
        }
        
        if (row.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User row) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (row.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (row.getAge() != null) {
            sql.SET("age = #{age,jdbcType=INTEGER}");
        }
        
        if (row.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=TINYINT}");
        }
        
        if (row.getBirthday() != null) {
            sql.SET("birthday = #{birthday,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}