package com.mrsaber.mapper;

import com.mrsaber.model.BackP;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BackPMapper {
    @Insert("INSERT INTO `gongxiao`.`ms_backP` (`bp_or_id`, `bp_number`, `bp_date`, `bp_other`,`bp_su_id`) VALUES (#{bp_or_id}, #{bp_number}, #{bp_date}, #{bp_other},#{bp_su_id});")
    void add(BackP p);

    @Select("SELECT * FROM gongxiao.ms_backP WHERE bp_su_id=#{id};")
    List<BackP> get(Integer id);
}
