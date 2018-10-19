package com.mrsaber.dao;

import com.mrsaber.mapper.InvoiceMapper;
import com.mrsaber.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    /**
     * 添加发票
     *
     * @param invoice
     */
    public void addInvoice(Invoice invoice) {
        invoiceMapper.addInvoice(invoice);
    }

    public void delInvoice(Integer id) {
        invoiceMapper.deleteById(id);
    }

    public List<Invoice> getInBySaleId(Integer saleId) {
        return invoiceMapper.getInvoiceBySaleId(saleId);
    }

}
