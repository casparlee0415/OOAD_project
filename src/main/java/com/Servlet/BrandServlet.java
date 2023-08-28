package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import com.Entity.*;
import com.Service.BrandService;
import com.Service.ScooterService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;

public class BrandServlet extends HttpServlet{
    private static final String BRAND_PAGE_URL = "WEB-INF/jsp/brand.jsp";
    private final BrandService brandService=new BrandService();
    private final ScooterService scooterService=new ScooterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String webapp=getServletContext().getRealPath("/").replace('\\','/');
        int brandId=Integer.parseInt(req.getParameter("brandId").toString());
        Brand brand=brandService.selectBrandByBrandId(brandId);
        List<Scooter> scooterList=scooterService.selectScooterByBrandId(brandId);
        Map<Integer,String> imageMap=new HashMap<>();

        for(Scooter scooter:scooterList){
            String url=webapp+"img/scooter/"+scooter.getName()+".jpeg";
            imageMap.put(scooter.getId(),fileToBase64(url));
        }
        req.setAttribute("scooterList", scooterList);
        req.setAttribute("brand",brand);
        req.setAttribute("scooterImgMap",imageMap);
        req.getRequestDispatcher(BRAND_PAGE_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req,resp);
    }

    private static String fileToBase64(String url) throws IOException {
        File file=new File(url);
        if(!file.exists()) return "";

        byte[] fileContent = FileUtils.readFileToByteArray(new File(url));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }
}
