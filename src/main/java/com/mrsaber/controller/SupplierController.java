package com.mrsaber.controller;
import com.mrsaber.dao.SupplierService;
import com.mrsaber.model.Supplier;
import com.mrsaber.model.SupplierItem;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 供应商管理
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @RequestMapping(value = "/getALlSupplierInfo.do")
    public List<Supplier> getALlSupplierInfo(HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");//解决跨域请求问题
        System.out.println("Hello");
        return supplierService.getAllSupplierInfo().getData();
    }
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    public String addSupplier(Supplier supplier)
    {
        System.out.println(supplier);
        try {
            supplierService.addSupplier(supplier);
        }catch (Exception e)
        {
            e.printStackTrace();
            return "出现异常";
        }
        return "添加成功";

    }
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "del.do")
    public String delSupplier(Integer ID)
    {
        try {
            supplierService.delSupplierById(ID);
        }catch (Exception e)
        {
            e.printStackTrace();
            return "操作异常";
        }
        return "操作成功";
    }
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "update.do")
    public String update(Supplier su)
    {
        try{ supplierService.updateSu(su);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }

        return "操作成功";
    }
}
