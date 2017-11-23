package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserDynaSqlProvider {

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public String updateUser(User user){
        return new SQL(){
            {
                UPDATE("t_user");
                if (user.getUsername() != null){
                    SET("username=#{username}");
                }
                if (user.getPassword() != null){
                    SET("password=#{password}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    /**
     * 根据条件获得用户信息
     * @param param
     * @return
     */
    public String selectWhitParam(Map<String,Object> param){
        return new SQL(){
            {
                SELECT("*");
                FROM("t_user");
                if (param.get("id") != null){
                    WHERE("id=#{id}");
                }
                if (param.get("username") != null){
                    WHERE("username=#{username}");
                }
            }
        }.toString();
    }

    /**
     * 创建用户信息
     * @param user
     * @return
     */
    public String insertUser(User user){
        return new SQL(){
            {
                INSERT_INTO("t_user");
                if (user.getUsername() != null){
                    VALUES("username","#{username}");
                }
                if (user.getPassword() != null){
                    VALUES("password","#{password}");
                }
            }
        }.toString();
    }
}
