package com.Dao;

import com.Entity.Brand;
import org.junit.*;

import java.util.*;
import static org.junit.Assert.*;

public class BrandDaoTest {

    private BrandDao brandDao;
    @Before
    public void setUp() throws Exception {
        brandDao=new BrandDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void show() {

        List<Brand> brandList=brandDao.show();
        assertEquals(14,brandList.get(0).getId().intValue());
        assertEquals("Aeonmetor 宏佳騰",brandList.get(0).getName());

    }

    @Test
    public void selectBrandByBrandId() {
        Brand brand= brandDao.selectBrandByBrandId(14);
        assertEquals("Aeonmetor 宏佳騰",brand.getName());
    }
}