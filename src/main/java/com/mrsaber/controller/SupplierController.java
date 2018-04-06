package com.mrsaber.controller;
import com.mrsaber.dao.SupplierService;
import com.mrsaber.model.Supplier;
import com.mrsaber.model.SupplierItem;
import com.mrsaber.model.onePage;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 供应商管理
 */
@RestController
@RequestMapping("supplier")
@CrossOrigin
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    /**
     * 获得所有信息
     * @return
     */
    @RequestMapping(value = "/getAllSupplierInfo.do")
    public List<Supplier> getALlSupplierInfo()
    {
        try {
            return supplierService.getAllSupplierInfo().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得分页信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/getByPage.do")
    @Transactional
    public onePage getListByPage(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "50")Integer rows )
    {
        try {
            return supplierService.getListByPage(rows,(page-1)*rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


    @RoleCheck(level = {3})
    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    public String add(Supplier supplier)
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
    @RoleCheck(level = {3})
    @RequestMapping(value = "del.do")
    public String del(Integer ID)
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
    @RoleCheck(level = {3})
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

    @RequestMapping(value = "/getListByLikeName.do")
    public List<Supplier> getListByLikeName(String likeStr)
    {
        try{
            return supplierService.getListByLikeName(likeStr);}
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
