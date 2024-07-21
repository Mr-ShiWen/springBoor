package org.example.myspringboot.beanFinder;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.myspringboot.mybatis.mapper.xml.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@Component
public class BeanFinder {
    @Autowired
    DataSource dataSource;

    @Autowired
    PlatformTransactionManager txManager;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public void batchOperate(){
        // 创建带有 batch executor 的 DefautSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行批处理操作
    }


    public  void find(){
        HikariDataSource dataSource1;
        JdbcTransactionManager txm;
        log.info("find dataSource:{}",dataSource);
        log.info("find platformTransactionManager:{}",txManager);
    }
}
