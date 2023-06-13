package com.Servlet;

import com.Servlet.ScooterServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.mock.web.MockServletConfig;

import java.io.IOException;

import static org.junit.Assert.*;

public class ScooterServletTest {
    private ScooterServlet servlet;
    @Before
    public void setUp() throws Exception {
        servlet=new ScooterServlet();
        servlet.init(new MockServletConfig());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doGet() throws IOException, ServletException{
        MockHttpServletRequest req=new MockHttpServletRequest();
        req.setParameter("scooterId","14");
        MockHttpServletResponse resp=new MockHttpServletResponse();
        servlet.doGet(req,resp);
        assertEquals(200,resp.getStatus());
    }

    @Test
    public void doPost() throws IOException, ServletException{
        MockHttpServletRequest req=new MockHttpServletRequest();
        req.setParameter("scooterId","14");
        MockHttpServletResponse resp=new MockHttpServletResponse();
        servlet.doPost((HttpServletRequest) req, (HttpServletResponse) resp);
        assertEquals(200,resp.getStatus());
    }
}