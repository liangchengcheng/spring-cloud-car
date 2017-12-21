package com.hdsx.car.company.service.hystrix;

import com.hdsx.car.company.service.CompanyService;
import com.hdsx.car.model.Combotree;
import com.hdsx.car.model.CompanyVo;
import com.hdsx.car.model.Pagination;
import org.springframework.stereotype.Component;

import java.util.List;

import com.hdsx.car.company.service.CompanyService;
import com.hdsx.car.model.Combotree;
import com.hdsx.car.model.CompanyVo;
import com.hdsx.car.model.Pagination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceHystrix implements CompanyService {
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

