package com.hdsx.car.model;

import java.io.Serializable;

public class CompanyVo implements Serializable{

    private CompanyRegist campanyRegist;
    private CompanyQualification campanyQualification;

    public CompanyVo() {
        super();
    }

    public CompanyVo(CompanyRegist campanyRegist, CompanyQualification campanyQualification) {
        super();
        this.campanyRegist = campanyRegist;
        this.campanyQualification = campanyQualification;
    }

    public CompanyRegist getCampanyRegist() {
        return campanyRegist;
    }

    public void setCampanyRegist(CompanyRegist campanyRegist) {
        this.campanyRegist = campanyRegist;
    }

    public CompanyQualification getCampanyQualification() {
        return campanyQualification;
    }

    public void setCampanyQualification(CompanyQualification campanyQualification) {
        this.campanyQualification = campanyQualification;
    }
}
