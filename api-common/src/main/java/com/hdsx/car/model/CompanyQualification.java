package com.hdsx.car.model;

import java.io.Serializable;

public class CompanyQualification implements Serializable{
    private String societyId;
    private String idType;
    private String campanyLevel;
    private String qualificationName;
    private String qualificationNumber;
    private String qualificationInstitution;
    private String qualificationAssessDate;
    private String qualificationExpireDate;
    private String status;
    private String updateTime;
    private String permitPlace;
    private String conferInstitution;
    private String conferTime;

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getCampanyLevel() {
        return campanyLevel;
    }

    public void setCampanyLevel(String campanyLevel) {
        this.campanyLevel = campanyLevel;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationNumber() {
        return qualificationNumber;
    }

    public void setQualificationNumber(String qualificationNumber) {
        this.qualificationNumber = qualificationNumber;
    }

    public String getQualificationInstitution() {
        return qualificationInstitution;
    }

    public void setQualificationInstitution(String qualificationInstitution) {
        this.qualificationInstitution = qualificationInstitution;
    }

    public String getQualificationAssessDate() {
        return qualificationAssessDate;
    }

    public void setQualificationAssessDate(String qualificationAssessDate) {
        this.qualificationAssessDate = qualificationAssessDate;
    }

    public String getQualificationExpireDate() {
        return qualificationExpireDate;
    }

    public void setQualificationExpireDate(String qualificationExpireDate) {
        this.qualificationExpireDate = qualificationExpireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPermitPlace() {
        return permitPlace;
    }

    public void setPermitPlace(String permitPlace) {
        this.permitPlace = permitPlace;
    }

    public String getConferInstitution() {
        return conferInstitution;
    }

    public void setConferInstitution(String conferInstitution) {
        this.conferInstitution = conferInstitution;
    }

    public String getConferTime() {
        return conferTime;
    }

    public void setConferTime(String conferTime) {
        this.conferTime = conferTime;
    }
}
