package com.Service;

import com.Entity.Brand;
import com.Service.BrandService;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class BrandServiceTest {
    private BrandService brandService;

    @Before
    public void setUp() throws Exception{
        brandService=new BrandService();
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void show() {
        List<Brand> brandList=brandService.show();
        assertEquals(14,brandList.get(0).getId().intValue());
        assertEquals("Aeonmetor 宏佳騰",brandList.get(0).getName());

    }

    @Test
    public void selectBrandByBrandId() {
        Brand brand= brandService.selectBrandByBrandId(14);
        assertEquals("Aeonmetor 宏佳騰",brand.getName());
    }
}
