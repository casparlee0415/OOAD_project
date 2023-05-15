package com.Service;

import com.Dao.BrandDao;
import com.Entity.Brand;
import java.util.*;

public class BrandService {
    private final BrandDao brandDao=new BrandDao();

    public List<Brand> show(){
        return brandDao.show();
    }

    public Brand selectBrandByBrandId(int brandId){
        return brandDao.selectBrandByBrandId(brandId);
    }
}
