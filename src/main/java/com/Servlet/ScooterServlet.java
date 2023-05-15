package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;
import com.Entity.*;
import com.Entity.Brand;
import com.Entity.Scooter;
import com.Service.BrandService;
import com.Service.ScooterService;

public class ScooterServlet extends HttpServlet{

    private static final String SCOOTER_PAGE_URL = "WEB-INF/jsp/scooter.jsp";

    private final ScooterService scooterService=new ScooterService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int scooterId=Integer.parseInt(req.getParameter("scooterId").toString());
        Scooter scooter=scooterService.selectScooterByScooterId(scooterId);
        Brand brand= scooter.getBrand();
        List<Scooter> otherScooterList = scooterService
                .selectScooterByBrandIdWhereNotEqualScooterId(brand.getId(),scooterId);

        req.setAttribute("scooter", scooter);
        req.setAttribute("otherScooterList", otherScooterList);
        req.setAttribute("brand",brand);
        req.getRequestDispatcher(SCOOTER_PAGE_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int scooterId=Integer.parseInt(req.getParameter("scooterId").toString());
        Scooter scooter=scooterService.selectScooterByScooterId(scooterId);
        Brand brand= scooter.getBrand();
        List<Scooter> otherScooterList = scooterService
                .selectScooterByBrandIdWhereNotEqualScooterId(brand.getId(),scooterId);

        req.setAttribute("scooter", scooter);
        req.setAttribute("otherScooterList", otherScooterList);
        req.setAttribute("brand",brand);
        req.getRequestDispatcher(SCOOTER_PAGE_URL).forward(req, resp);
    }
}
