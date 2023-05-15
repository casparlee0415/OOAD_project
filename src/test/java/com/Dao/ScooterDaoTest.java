package com.Dao;

import com.Entity.Scooter;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class ScooterDaoTest {

    private ScooterDao scooterDao;
    @Before
    public void setUp() throws Exception {
        scooterDao=new ScooterDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectScooterByBrandId() {
        List<Scooter> scooterList=scooterDao.selectScooterByBrandId(14);
        assertEquals("2023 Aeonmotor 3D 350 R",scooterList.get(0).getName());
    }
    @Test
    public void selectScooterByScooterId() {
        Scooter scooter=scooterDao.selectScooterByScooterId(14);
        assertEquals("2023 Aeonmotor 3D 350 R",scooter.getName());
    }

    @Test
    public void selectScooterByBrandIdWhereNotEqualScooterId() {
        List<Scooter> scooterList=scooterDao.selectScooterByBrandIdWhereNotEqualScooterId(14,14);
        assertEquals("2023 Aeonmotor Ai-4 Ever",scooterList.get(0).getName());
    }
}