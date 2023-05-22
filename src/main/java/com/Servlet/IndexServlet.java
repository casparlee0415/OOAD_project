package com.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.Entity.*;
import com.Service.*;
import org.apache.commons.io.*;

public class IndexServlet extends HttpServlet{
    private static final String INDEX_PAGE_URL = "WEB-INF/jsp/index.jsp";
    private final BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandList=brandService.show();
        Map<Integer,String> imageMap=new HashMap<>();
        String webapp=getServletContext().getRealPath("/").replace('\\','/');

        for(Brand brand:brandList){
            String url=webapp+"img/brand/"+brand.getName()+".jpeg";
            imageMap.put(brand.getId(),fileToBase64(url));
        }
        req.setAttribute("brandList", brandList);
        req.setAttribute("brandImgMap",imageMap);
        req.getRequestDispatcher(INDEX_PAGE_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private static String fileToBase64(String url) throws IOException {
        File file=new File(url);
        if(!file.exists()) return "";

        byte[] fileContent = FileUtils.readFileToByteArray(file);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }
}
