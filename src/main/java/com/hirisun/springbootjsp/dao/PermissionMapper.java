package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("select * from t_permission p right join (select p1.p_id from t_role_permission p1 right join t_user_role u on p1.r_id = u.r_id where u.u_id=#{id}) p2 on p.id = p2.p_id")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "description",column = "description"),
            @Result(property = "url",column = "url"),
            @Result(property = "parentId",column = "parentId")
    })
    List<Permission> getByUserId(Long id);
}
