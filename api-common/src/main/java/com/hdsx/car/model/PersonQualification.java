package com.hdsx.car.model;

import java.io.Serializable;

public class PersonQualification implements Serializable {
    private String IDCardType;
    private String IDCardNumber;
    private String certificateNumber;
    private String certificateType;
    private String certificateExpireDate;
    private String certificateInstitution;
    private String certificateStatus;
    private String carDriverType;
    private String carCertificateAssessDate;
    private String carCertificateExpireDate;
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

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateExpireDate() {
        return certificateExpireDate;
    }

    public void setCertificateExpireDate(String certificateExpireDate) {
        this.certificateExpireDate = certificateExpireDate;
    }

    public String getCertificateInstitution() {
        return certificateInstitution;
    }

    public void setCertificateInstitution(String certificateInstitution) {
        this.certificateInstitution = certificateInstitution;
    }

    public String getCertificateStatus() {
        return certificateStatus;
    }

    public void setCertificateStatus(String certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public String getCarDriverType() {
        return carDriverType;
    }

    public void setCarDriverType(String carDriverType) {
        this.carDriverType = carDriverType;
    }

    public String getCarCertificateAssessDate() {
        return carCertificateAssessDate;
    }

    public void setCarCertificateAssessDate(String carCertificateAssessDate) {
        this.carCertificateAssessDate = carCertificateAssessDate;
    }

    public String getCarCertificateExpireDate() {
        return carCertificateExpireDate;
    }

    public void setCarCertificateExpireDate(String carCertificateExpireDate) {
        this.carCertificateExpireDate = carCertificateExpireDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
