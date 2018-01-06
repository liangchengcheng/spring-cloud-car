package com.hdsx.car.company.service.hystrix;

import com.hdsx.car.company.service.CompanyService;
import com.hdsx.car.model.*;
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
    public BaseResult getCompanyList(int pageNo, int pageSize, String campanyName, String registCity) {
        return null;
    }

    @Override
    public BaseResult addCompany(CompanyVo companyVo) {
        return null;
    }

    @Override
    public BaseResult updateCompany(CompanyVo companyVo) {
        return null;
    }

    @Override
    public BaseResult deleteCompany(String camSocietyId) {
        return null;
    }

    @Override
    public BaseResult getCompany(String camSocietyId) {
        return null;
    }

    @Override
    public BaseResult checkCompany(String camSocietyId) {
        return null;
    }

    @Override
    public BaseResult getCompanyTree() {
        return null;
    }
}

