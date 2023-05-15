package com.Servlet;

import com.Servlet.BrandServlet;
import org.junit.*;
import org.springframework.mock.web.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;
import java.io.IOException;
import static org.junit.Assert.*;


public class BrandServletTest {

    private BrandServlet servlet;

    @Before
    public void setUp() throws Exception {
        servlet=new BrandServlet();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doGet() throws IOException, ServletException {
        MockHttpServletRequest req=new MockHttpServletRequest();
        req.setParameter("brandId","34");
        MockHttpServletResponse resp=new MockHttpServletResponse();
        servlet.doGet(req,resp);
        assertEquals(200,resp.getStatus());
    }

    @Test
    public void doPost() throws IOException, ServletException{
        MockHttpServletRequest req=new MockHttpServletRequest();
        req.setParameter("brandId","34");
        MockHttpServletResponse resp=new MockHttpServletResponse();
        servlet.doPost(req,resp);
        assertEquals(200,resp.getStatus());
    }
}