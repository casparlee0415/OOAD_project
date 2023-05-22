package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import com.Entity.*;
import com.Entity.Brand;
import com.Entity.Scooter;
import com.Service.BrandService;
import com.Service.ScooterService;
import org.apache.commons.io.FileUtils;

public class ScooterServlet extends HttpServlet{

    private static final String SCOOTER_PAGE_URL = "WEB-INF/jsp/scooter.jsp";

    private final ScooterService scooterService=new ScooterService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String webapp=getServletContext().getRealPath("/").replace('\\','/');
        int scooterId=Integer.parseInt(req.getParameter("scooterId").toString());
        Scooter scooter=scooterService.selectScooterByScooterId(scooterId);
        Brand brand= scooter.getBrand();
        List<Scooter> otherScooterList = scooterService
                .selectScooterByBrandIdWhereNotEqualScooterId(brand.getId(),scooterId);
        Map<Integer,String> imageMap=new HashMap<>();

        String url=webapp+"img/scooter/"+scooter.getName()+".jpeg";
        imageMap.put(scooter.getId(),fileToBase64(url));

        for(Scooter otherScooter:otherScooterList){
            String otherUrl=webapp+"img/scooter/"+otherScooter.getName()+".jpeg";
            imageMap.put(otherScooter.getId(),fileToBase64(otherUrl));
        }

        req.setAttribute("scooter", scooter);
        req.setAttribute("otherScooterList", otherScooterList);
        req.setAttribute("brand",brand);
        req.setAttribute("scooterImgMap",imageMap);
        req.getRequestDispatcher(SCOOTER_PAGE_URL).forward(req, resp);
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
