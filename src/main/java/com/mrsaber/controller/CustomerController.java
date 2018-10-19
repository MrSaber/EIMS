package com.mrsaber.controller;

import com.mrsaber.dao.CustomerService;
import com.mrsaber.dao.SupplierService;
import com.mrsaber.model.*;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ZY on 2017/11/11.
 */
@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 获得所有的供应商信息？
     *
     * @return
     */
    @RequestMapping(value = "/get.do")
    public CustomerItem getALlSupplierInfo() {
        return customerService.getALlCustomer();
    }

    /**
     * 获得负责人
     *
     * @return
     */
    @RequestMapping(value = "/getP.do")
    public List<Customer> getP(Integer key) {
        System.out.println("Hello");
        return customerService.getCustomerByLabId(key);
    }

    @RequestMapping(value = "/getById.do")
    public Customer getById(Integer id) {
        return customerService.getById(id);
    }

    @RequestMapping(value = "/getCuTree.do")
    public TreeNode[] getCuTree(HttpServletResponse response) {
        TreeNode[] nodeTree = new TreeNode[1];
        nodeTree[0] = customerService.getCuTree();
        return nodeTree;
    }

    @RoleCheck(level = {3})
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addCustomer(Customer customer) {
        System.out.println(customer);
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "操作成功";
    }

    @RoleCheck(level = {3})
    @RequestMapping(value = "/update.do")
    public String update(Customer c) {
        try {
            customerService.update(c);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "操作成功";
    }

    @RoleCheck(level = {3})
    @RequestMapping(value = "/del.do")
    public String delSupplier(Integer id) {
        try {
            customerService.delCustomer(id);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "操作成功";
    }

    @RequestMapping(value = "/getListByLikeName.do")
    public List<Customer> getListByLikeName(String likeStr) {
        return customerService.getListByLikeName1(likeStr);
    }
}