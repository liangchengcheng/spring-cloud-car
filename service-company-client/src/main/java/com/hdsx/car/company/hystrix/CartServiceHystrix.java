package com.hdsx.car.company.hystrix;

import com.hdsx.car.company.CompanyService;
import com.hdsx.car.model.Combotree;
import com.hdsx.car.model.CompanyVo;
import com.hdsx.car.model.Pagination;

import java.util.List;

public class CartServiceHystrix implements CompanyService {
    @Override
    public Pagination getCompanys(Integer pageNo, Integer pageSize, String campanyName, String registCity) {
        return null;
    }

    @Override
    public boolean addCompany(CompanyVo companyVo) {
        return false;
    }

    @Override
    public boolean updateCampany(CompanyVo companyVo) {
        return false;
    }

    @Override
    public boolean deleteCampany(String camSocietyId) {
        return false;
    }

    @Override
    public CompanyVo getCampany(String camSocietyId) {
        return null;
    }

    @Override
    public boolean checkCampany(String camSocietyId) {
        return false;
    }

    @Override
    public List<Combotree> getCampanyTree() {
        return null;
    }
}
