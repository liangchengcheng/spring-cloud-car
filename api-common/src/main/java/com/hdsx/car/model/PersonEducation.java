package com.hdsx.car.model;

import java.io.Serializable;

public class PersonEducation implements Serializable{
    private String IDCardType;
    private String IDCardNumber;
    private String starTime;
    private String endTime;
    private String educationContent;
    private String educationScore;
    private String certificateStatus;
    private String educationInstitution;
    private String updateTime;

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

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEducationContent() {
        return educationContent;
    }

    public void setEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    public String getEducationScore() {
        return educationScore;
    }

    public void setEducationScore(String educationScore) {
        this.educationScore = educationScore;
    }

    public String getCertificateStatus() {
        return certificateStatus;
    }

    public void setCertificateStatus(String certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public String getEducationInstitution() {
        return educationInstitution;
    }

    public void setEducationInstitution(String educationInstitution) {
        this.educationInstitution = educationInstitution;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
