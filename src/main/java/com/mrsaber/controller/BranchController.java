package com.mrsaber.controller;

import com.mrsaber.dao.BranchService;
import com.mrsaber.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("branch")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @RequestMapping("/add.do")
    public String add(Branch branch)
    {
        try{
            branchService.addBranch(branch);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "添加失败";
        }
       return "添加成功";
    }

    @RequestMapping("/del.do")
    public String del(Integer id)
    {
        try{
            branchService.delBranch(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/gets.do")
    public List<Branch> get(int key)
    {
        return branchService.getBranchByOfficeId(key);
    }

    @RequestMapping("/excel.do")
    public void excel(HttpServletResponse response,String txtContent)
    {
        System.out.println(txtContent);
        response.setHeader("charset","utf-8");
        response.setContentType("Application/ms-excel");
        response.addHeader("content-disposition","attachment;filename=data.xls");
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().write("<html>\\n<head>\\n");
            response.getWriter().write("<style type=\"text/css\">\n.pb{font-size:13px;border-collapse:collapse;} "+
                    "\n.pb th{font-weight:bold;text-align:center;border:0.5pt solid windowtext;padding:2px;} " +
                    "\n.pb td{border:0.5pt solid windowtext;padding:2px;}\n</style>\n</head>\n");

            response.getWriter().write("<body>\n" +txtContent + "\n</body>\n</html>");
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
