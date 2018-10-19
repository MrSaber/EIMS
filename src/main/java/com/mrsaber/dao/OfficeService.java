package com.mrsaber.dao;

import com.mrsaber.mapper.OfficeMappper;
import com.mrsaber.model.Customer;
import com.mrsaber.model.CustomerItem;
import com.mrsaber.model.Office;
import com.mrsaber.model.OfficeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZY on 2017/11/11.
 */
@Service
public class OfficeService {
    @Autowired
    private OfficeMappper officeMappper;

    public OfficeItem getAllOffice() {
        List<Office> offices = officeMappper.getAllOffice();
        OfficeItem officeItem = new OfficeItem();
        officeItem.setMsg("Hello");
        officeItem.setCount(offices.size());
        officeItem.setCode(0);
        officeItem.setData(offices);
        return officeItem;
    }

    public void addOffice(Office office) {
        officeMappper.addOffice(office);
    }

    public void delOffice(Integer id) {
        officeMappper.delOffice(id);
    }
}
