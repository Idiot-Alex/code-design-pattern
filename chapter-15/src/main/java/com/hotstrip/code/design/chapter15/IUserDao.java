package com.hotstrip.code.design.chapter15;

import com.hotstrip.code.design.chapter15.base.Select;
import org.apache.ibatis.annotations.Mapper;

/**
 * 模拟 User Dao 接口
 * @author Hotstrip
 */
@Mapper
public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
