package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Insert("insert into t_user(username,password) values (#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(User user);

    @Delete("delete from t_user where id=#{#id}")
    int removeUser(Long id);

    @Select("select * from t_user where username=#{username}")
    @Results({
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password")
    })
    User getByUserName(String username);

    @UpdateProvider(type = UserDynaSqlProvider.class,method = "updateUser")
    int updateUser(User user);

    @Select("select * from t_user")
    List<User> getAll();

    @SelectProvider(type = UserDynaSqlProvider.class,method = "selectWhitParam")
    List<User> selectWhitParam(Map<String,Object> param);

    @InsertProvider(type = UserDynaSqlProvider.class,method = "insertUser")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);
}
