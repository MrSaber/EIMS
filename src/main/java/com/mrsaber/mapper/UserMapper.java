package com.mrsaber.mapper;

import com.mrsaber.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `gongxiao`.`ms_user` (`user_name`, `user_password`, `user_role`, `user_other`) VALUES (#{user_name}, #{user_password}, #{user_role}, #{user_other});")
    void  add(User user);

    @Select("SELECT * FROM `gongxiao`.`ms_user` WHERE user_name=#{user_name} and user_password = #{user_password}")
    User get(User user);

    @Select("SELECT * FROM `gongxiao`.`ms_user`;")
    List<User> getAll();

    @Delete("DELETE FROM `gongxiao`.`ms_user` WHERE user_id = #{user_id}")
    void del(User user);

    @Update("UPDATE `gongxiao`.`ms_user` SET `user_name`=#{user_name}, `user_password`=#{user_password}, `user_role`=#{user_role}, `user_other`=#{user_other} WHERE `user_id`=#{user_id};")
    void update(User user);

}
