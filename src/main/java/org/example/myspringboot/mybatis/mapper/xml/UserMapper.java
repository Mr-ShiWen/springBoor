package org.example.myspringboot.mybatis.mapper.xml;

import org.example.myspringboot.mybatis.entity.User;
import org.springframework.stereotype.Component;

@Component("xmlMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}