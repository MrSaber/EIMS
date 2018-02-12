package com.mrsaber.dao;

import com.mrsaber.mapper.LabMapper;
import com.mrsaber.model.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabService {
    @Autowired
    private LabMapper labMapper;
    public List<Lab> getLabByBranchId(int id)
    {
        return labMapper.getLabByBranchId(id);
    }
    public void addLab(Lab lab)
    {
        labMapper.addLab(lab);
    }
    public void delLab(Integer id)
    {
        labMapper.delLab(id);
    }
}
