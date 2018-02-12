package com.mrsaber.mapper;

import com.mrsaber.model.Branch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BranchMapper {
    @Select("SELECT * FROM ms_branch WHERE br_office_id=#{id}")
    List<Branch> getBranchByOfficeId(Integer id);
    @Insert("INSERT INTO `gongxiao`.`ms_branch` (`br_office_id`, `br_name`, `br_other`) VALUES (#{br_office_id}, #{br_name}, #{br_other})")
    void addBranch(Branch branch);

    @Delete("DELETE FROM ms_branch WHERE br_id = #{id}")
    void delBranch(Integer id);
}
