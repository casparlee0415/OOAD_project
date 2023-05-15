package com.Service;

import com.Dao.ScooterDao;
import com.Entity.Scooter;

import java.util.*;
public class ScooterService {
    private final ScooterDao scooterDao=new ScooterDao();

    public List<Scooter> selectScooterByBrandId(int brandId){
        return scooterDao.selectScooterByBrandId(brandId);
    }

    public Scooter selectScooterByScooterId(int scooterId){
        return scooterDao.selectScooterByScooterId(scooterId);
    }

    public List<Scooter> selectScooterByBrandIdWhereNotEqualScooterId(int brandId,int scooterId){
        return scooterDao.selectScooterByBrandIdWhereNotEqualScooterId(brandId,scooterId);
    }
}
