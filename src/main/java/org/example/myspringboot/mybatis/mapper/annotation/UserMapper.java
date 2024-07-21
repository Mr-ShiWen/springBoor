package org.example.myspringboot.mybatis.mapper.annotation;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.myspringboot.mybatis.entity.User;
import org.springframework.stereotype.Component;

@Component("annotationMapper")
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (user_name, age, ",
        "sex, birthday)",
        "values (#{userName,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
        "#{sex,jdbcType=TINYINT}, #{birthday,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User row);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(User row);

    @Select({
        "select",
        "id, user_name, age, sex, birthday",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User row);

    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=TINYINT},",
          "birthday = #{birthday,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User row);
}