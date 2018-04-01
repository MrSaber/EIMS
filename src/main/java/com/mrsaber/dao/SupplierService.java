package com.mrsaber.dao;

import com.mrsaber.mapper.SupplierMapper;
import com.mrsaber.model.Supplier;
import com.mrsaber.model.SupplierItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by ZY on 2017/11/11.
 */
@Service
public class SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    public SupplierItem getAllSupplierInfo()
    {

        SupplierItem supplierItem = new SupplierItem();
        List<Supplier> suppliers =supplierMapper.getAllSupplierInfo();
        supplierItem.setData(suppliers);
        supplierItem.setCount(suppliers.size());
        supplierItem.setCode(0);
        supplierItem.setMsg("supplier_info");
        return supplierItem;
    }
    public void addSupplier(Supplier supplier)
    {
        supplierMapper.addSupplier(supplier);
    }
    public void delSupplierById(Integer id)
    {
        supplierMapper.delSupplierById(id);
    }
    public Supplier getSupplierById(Integer id){return supplierMapper.getSupplierById(id);}
    public void updateSu(Supplier supplier)
    {
        supplierMapper.updateSu(supplier);
    }

    public List<Supplier> getListByLikeName(String like)
    {
        return supplierMapper.getListByLikeName("%"+like+"%");
    }
}