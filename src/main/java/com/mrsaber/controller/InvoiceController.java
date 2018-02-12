package com.mrsaber.controller;

import com.mrsaber.dao.InvoiceService;
import com.mrsaber.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("in")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    /**
     * 开发票
     * @param invoice
     * @return
     */
    @RequestMapping(value = "/add.do")
    public String add(Invoice invoice)
    {
        try {
            invoice.setIn_other(java.net.URLDecoder.decode(invoice.getIn_other(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
            invoiceService.addInvoice(invoice);
        return "添加成功";
    }

    /**
     * 获得发票
     * @param saleId
     * @return
     */
    @RequestMapping(value = "/get.do")
    public List<Invoice> get(Integer saleId)
    {
        return invoiceService.getInBySaleId(saleId);
    }

    /**
     * 修改发票信息
     * @param invoice 发票信息
     */
    @RequestMapping(value = "/update.do")
    public String update(Invoice invoice)
    {
        return null;
    }

    /**
     * 删除发票
     * @param inId 发票ID
     * @return
     */
    @RequestMapping(value = "/del.do")
    public String del(Integer inId)
    {
        try{invoiceService.delInvoice(inId);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "删除成功";
    }

}
