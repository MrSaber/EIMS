package com.mrsaber.mapper;

import com.mrsaber.model.Lab;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LabMapper {

    @Select("SELECT * FROM ms_lab WHERE lab_branch_id=#{id}")
    List<Lab> getLabByBranchId(Integer id);
    @Insert("INSERT INTO `gongxiao`.`ms_lab` (`lab_branch_id`, `lab_name`,`lab_other`) VALUES (#{lab_branch_id}, #{lab_name}, #{lab_other})")
    void addLab(Lab lab);
    @Delete("DELETE FROM ms_lab WHERE lab_id = #{id}")
    void delLab(Integer lab);
}
