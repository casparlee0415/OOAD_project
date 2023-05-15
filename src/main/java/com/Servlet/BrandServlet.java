package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;
import com.Entity.*;
import com.Entity.Brand;
import com.Service.BrandService;
import com.Service.ScooterService;
import com.Entity.Scooter;

public class BrandServlet extends HttpServlet{
    private static final String BRAND_PAGE_URL = "WEB-INF/jsp/brand.jsp";
    private final BrandService brandService=new BrandService();
    private final ScooterService scooterService=new ScooterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int brandId=Integer.parseInt(req.getParameter("brandId").toString());
        Brand brand=brandService.selectBrandByBrandId(brandId);
        List<Scooter> scooterList=scooterService.selectScooterByBrandId(brandId);

        req.setAttribute("scooterList", scooterList);
        req.setAttribute("brand",brand);
        req.getRequestDispatcher(BRAND_PAGE_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int brandId=Integer.parseInt(req.getParameter("brandId").toString());
        Brand brand=brandService.selectBrandByBrandId(brandId);
        List<Scooter> scooterList=scooterService.selectScooterByBrandId(brandId);

        req.setAttribute("scooterList", scooterList);
        req.setAttribute("brand",brand);
        req.getRequestDispatcher(BRAND_PAGE_URL).forward(req, resp);
    }
}
