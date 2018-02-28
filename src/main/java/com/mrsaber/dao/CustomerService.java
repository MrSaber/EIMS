package com.mrsaber.dao;

import com.mrsaber.mapper.BranchMapper;
import com.mrsaber.mapper.CustomerMapper;
import com.mrsaber.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ZY on 2017/11/11.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BranchService branchService;
    @Autowired
    private OfficeService officeService;


    public CustomerItem getALlCustomer()
    {
        List<Customer> customers =  customerMapper.getAllCustomer();
        CustomerItem customerItem = new CustomerItem();
        customerItem.setMsg("Hello");
        customerItem.setCount(customers.size());
        customerItem.setCode(0);
        customerItem.setData(customers);
        return customerItem;
    }

    public CustomerItem getLikeCustomer(String str)
    {
        List<Customer> customers =  customerMapper.getLikeCustomer("%"+str+"%");
        CustomerItem customerItem = new CustomerItem();
        customerItem.setMsg("Hello");
        customerItem.setCount(customers.size());
        customerItem.setCode(0);
        customerItem.setData(customers);
        return customerItem;
    }

    public void update(Customer customer)
    {
        customerMapper.update(customer);
    }

    public void addCustomer(Customer customer)
    {
        customerMapper.addCustomer(customer);
    }

    public void delCustomer(Integer id)
    {
        customerMapper.delCustomer(id);
    }
    public Customer getById(Integer id)
    {
        return customerMapper.getCustomerById(id);
    }

    public List<Customer> getCustomerByLabId(Integer id)
    {
        return customerMapper.getCustomerByLabId(id);
    }

    public TreeNode getCuTree()
    {
        TreeNode treeNode = new TreeNode();
        treeNode.setId("0");
        treeNode.setText("客户");
        TreeNodeAttr attr0 = new TreeNodeAttr();
        attr0.setType(-1);
        treeNode.setAttributes(attr0);
        /*
            遍历单位
         */
        List<TreeNode> officeList = new ArrayList<>();
        Iterator<Office> it = officeService.getAllOffice().getData().iterator();
        while (it.hasNext())
        {
            Office it_office = it.next();
            TreeNode officeNode = new TreeNode();
            officeNode.setId(String.valueOf(it_office.getOf_id()));
            officeNode.setText(it_office.getOf_name());
            officeNode.setIconCls("icon-more");

            TreeNodeAttr attr = new TreeNodeAttr();
            attr.setType(0);
            attr.setTargetVal(it_office.getOf_id());
            officeNode.setAttributes(attr);
            //officeNode.setState("closed");
            /*
                遍历机构
            */
            List<TreeNode> branchList = new ArrayList<>();
            Iterator<Branch> it_b = branchService.getBranchByOfficeId(it_office.getOf_id()).iterator();
            while (it_b.hasNext())
            {
                Branch it_branch = it_b.next();
                TreeNode branchNode = new TreeNode();
                branchNode.setId(String.valueOf(it_branch.getBr_id()));
                branchNode.setText(it_branch.getBr_name());
                branchNode.setIconCls("icon-add");
                TreeNodeAttr attr1 = new TreeNodeAttr();
                attr1.setType(1);
                attr1.setTargetVal(it_branch.getBr_id());
                branchNode.setAttributes(attr1);
                branchNode.setState("closed");

                    /*遍历负责人*/
                    List<TreeNode> cuList = new ArrayList<>();
                    Iterator<Customer> it_cu =customerMapper.getCustomerByLabId(it_branch.getBr_id()).iterator();
                    while (it_cu.hasNext())
                    {
                        Customer it_customer=it_cu.next();
                        TreeNode cuNode = new TreeNode();
                        cuNode.setText(it_customer.getCu_name());
                        TreeNodeAttr attr3 = new TreeNodeAttr();
                        attr3.setType(3);
                        attr3.setTargetVal(it_customer.getCu_id());
                        cuNode.setAttributes(attr3);
                        cuNode.setIconCls("icon-man");
                         /*遍历成员*/
                        List<TreeNode> cusList = new ArrayList<>();
                        Iterator<Customer> it_cus =customerMapper.getCustomerByFarId(it_customer.getCu_id()).iterator();
                        while (it_cus.hasNext())
                        {
                            Customer it_customers=it_cus.next();
                            TreeNode cusNode = new TreeNode();
                            cusNode.setText(it_customers.getCu_name());
                            cusNode.setIconCls("icon-man");
                            TreeNodeAttr attr4 = new TreeNodeAttr();
                            attr4.setType(4);
                            attr4.setTargetVal(it_customers.getCu_id());
                            cusNode.setAttributes(attr4);
                            cusList.add(cusNode);
                        }
                        cuNode.setChildren(cusList);
                        cuList.add(cuNode);
                    }
                branchNode.setChildren(cuList);
                branchList.add(branchNode);
            }
            officeNode.setChildren(branchList);
            officeList.add(officeNode);
        }
        treeNode.setChildren(officeList);
        return treeNode;
    }
}
