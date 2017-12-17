package com.hdsx.car.dao;

import com.hdsx.car.model.Combotree;
import com.hdsx.car.model.CompanyQualification;
import com.hdsx.car.model.CompanyRegist;
import com.hdsx.car.model.QueryBean;

import java.util.List;

public interface CompanyMapper {

    List<CompanyRegist> getList(QueryBean queryBean);

    int getTotal(QueryBean queryBean);

    //Boolean addCampany(CampanyVo campanyVo);

    int addCampanyRegist(CompanyRegist campanyRegist);

    int addCampanyQualification(CompanyQualification campanyQualification);

    int updateCampanyRegist(CompanyRegist campanyRegist);

    int updateCampanyQualification(CompanyQualification campanyQualification);

    int deleteCampanyRegist(String societyId);

    int deleteCampanyQualification(String societyId);

    CompanyRegist getCampanyRegist(String societyId);

    CompanyQualification getCampanyQualification(String societyId);

    List<Combotree> getCampanyTree();
}
