package com.hdsx.car.model;

import java.io.Serializable;
import java.util.List;

public class CompanyRegist implements Serializable{

    private String societyId;
    private String campanyName;
    private String legalRepresName;
    private String IDCardType;
    private String IDCardNumber;
    private String updateTime;
    private String campanyNature;
    private String registCity;
    private String campanyPhone;
    private String registTime;
    private String linkman;
    private List<CarInformation> children;

    public List<CarInformation> getChildren() {
        return children;
    }

    public void setChildren(List<CarInformation> children) {
        this.children = children;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getCampanyName() {
        return campanyName;
    }

    public void setCampanyName(String campanyName) {
        this.campanyName = campanyName;
    }

    public String getLegalRepresName() {
        return legalRepresName;
    }

    public void setLegalRepresName(String legalRepresName) {
        this.legalRepresName = legalRepresName;
    }

    public String getIDCardType() {
        return IDCardType;
    }

    public void setIDCardType(String iDCardType) {
        IDCardType = iDCardType;
    }

    public String getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(String iDCardNumber) {
        IDCardNumber = iDCardNumber;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCampanyNature() {
        return campanyNature;
    }

    public void setCampanyNature(String campanyNature) {
        this.campanyNature = campanyNature;
    }

    public String getRegistCity() {
        return registCity;
    }

    public void setRegistCity(String registCity) {
        this.registCity = registCity;
    }

    public String getCampanyPhone() {
        return campanyPhone;
    }

    public void setCampanyPhone(String campanyPhone) {
        this.campanyPhone = campanyPhone;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
}
