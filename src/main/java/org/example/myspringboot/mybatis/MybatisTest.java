package org.example.myspringboot.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.myspringboot.mybatis.entity.User;
import org.example.myspringboot.mybatis.mapper.annotation.UserMapper;

import org.example.myspringboot.util.DateUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.example.myspringboot.mybatis.mapper.dynamic.UserDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Component
@Slf4j
public class MybatisTest {


    @Qualifier("annotationMapper")
    @Autowired
    UserMapper annotationUserMapper;

    @Qualifier("dynamicMapper")
    @Autowired
    org.example.myspringboot.mybatis.mapper.dynamic.UserMapper dynamicUserMapper;

    @Qualifier("xmlMapper")
    @Autowired
    org.example.myspringboot.mybatis.mapper.xml.UserMapper xmlUserMapper;

    @Transactional
    public void testTransaction() {
        xmlUserMapper.insert(new User("springBoot", 13, Byte.valueOf("1"), DateUtils.parseDateFromStr("1994-02-16")));
        int a = 1 / 0;
    }


    public void testAnnotationUserMapper() {
        User user = annotationUserMapper.selectByPrimaryKey(1);
        log.info("annotation user:{}", user);
    }

    public void testDynamicUserMappper() {
        User user = dynamicUserMapper.selectOne(c -> c.where(id, isEqualTo(1))).get();
        log.info("dynamic user:{}", user);
    }

    public void testXmlUserMappper() {
        User user = xmlUserMapper.selectByPrimaryKey(1);
        log.info("xml user:{}", user);

        User user1 = new User();
        user1.setId(1);
        user1.setUserName("zhangsan1");
        xmlUserMapper.updateByPrimaryKeySelective(user1);
    }


}
