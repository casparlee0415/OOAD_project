package com.Service;

import java.util.*;

import com.Entity.Scooter;
import com.Service.ScooterService;
import org.junit.*;

import static org.junit.Assert.assertEquals;


public class ScooterServiceTest{
    private ScooterService scooterService;
    @Before
    public void setUp() throws Exception{
        scooterService=new ScooterService();
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void selectScooterByBrandId() {
        List<Scooter> scooterList=scooterService.selectScooterByBrandId(14);
        assertEquals("2023 Aeonmotor 3D 350 R",scooterList.get(0).getName());
    }

    @Test
    public void selectScooterByScooterId() {
        Scooter scooter=scooterService.selectScooterByScooterId(14);
        assertEquals("2023 Aeonmotor 3D 350 R",scooter.getName());
    }

    @Test
    public void selectScooterByBrandIdWhereNotEqualScooterId() {
        List<Scooter> scooterList=scooterService.selectScooterByBrandIdWhereNotEqualScooterId(14,14);
        assertEquals("2023 Aeonmotor Ai-4 Ever",scooterList.get(0).getName());
    }
}