package com.mrsaber.controller;

import com.mrsaber.dao.CustomerService;
import com.mrsaber.dao.OfficeService;
import com.mrsaber.model.CustomerItem;
import com.mrsaber.model.Office;
import com.mrsaber.model.OfficeItem;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZY on 2017/11/11.
 */
@RestController
@RequestMapping("office")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    /**
     * 获得所有单位
     *
     * @return
     */
    @RequestMapping(value = "/get.do")
    public OfficeItem getALlSupplierInfo() {
        return officeService.getAllOffice();
    }

    /**
     * 添加单位
     *
     * @param office
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/add.do")
    public String addOffice(Office office) {
        try {
            officeService.addOffice(office);
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败";
        }
        return "添加成功";
    }

    /**
     * 删除单位
     *
     * @param id
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/del.do")
    public String delOffice(Integer id) {
        try {
            officeService.delOffice(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }

    /**
     * 修改单位信息
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/update.do")
    public String updateOffice(Office office) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "修改成功";
    }
}
