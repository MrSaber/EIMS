package com.mrsaber.dao;

import com.mrsaber.mapper.BranchMapper;
import com.mrsaber.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchMapper branchMapper;

    public List<Branch> getBranchByOfficeId(Integer id) {
        return branchMapper.getBranchByOfficeId(id);
    }

    public void addBranch(Branch branch) {
        branchMapper.addBranch(branch);
    }

    public void delBranch(Integer id) {
        branchMapper.delBranch(id);
    }
}
