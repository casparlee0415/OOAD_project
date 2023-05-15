package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.Entity.Brand;
import com.Service.BrandService;

public class IndexServlet extends HttpServlet{
    private static final String INDEX_PAGE_URL = "WEB-INF/jsp/index.jsp";
    private final BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandList=brandService.show();
        req.setAttribute("brandList", brandList);
        req.setAttribute("Test","brandlist");
        req.getRequestDispatcher(INDEX_PAGE_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandList=brandService.show();
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher(INDEX_PAGE_URL).forward(req, resp);
    }
}
