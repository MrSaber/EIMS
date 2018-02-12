package com.mrsaber.controller;

import com.mrsaber.dao.CustomerService;
import com.mrsaber.dao.OfficeService;
import com.mrsaber.model.CustomerItem;
import com.mrsaber.model.Office;
import com.mrsaber.model.OfficeItem;
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
    @RequestMapping(value = "/get.do")
    public OfficeItem getALlSupplierInfo(HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");//解决跨域请求问题
        System.out.println("Hello");
        return officeService.getAllOffice();
    }

    @RequestMapping(value = "/add.do")
    public String addOffice(Office office)
    {
        try {
            officeService.addOffice(office);
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败";
        }
      return "添加成功";
    }

    @RequestMapping(value = "/del.do")
    public String delOffice(Integer id)
    {
        try{
            officeService.delOffice(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }
}
