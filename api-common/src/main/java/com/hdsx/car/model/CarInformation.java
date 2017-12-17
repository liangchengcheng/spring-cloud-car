package com.hdsx.car.model;

import java.io.Serializable;
import java.util.List;

public class CarInformation implements Serializable {

    private String societyId;
    private String plateNumber;// 车牌号--主键
    private String plateColor;
    private String certificateType;
    private String certificateNumber;
    private String brandNumber;
    private String carType;
    private String carLimitSeat;
    private String carTonnage;
    private String carTractionMass;
    private String carLength;
    private String carHigh;
    private String carWidth;
    private String businessScope;
    private String starTime;
    private String endTime;
    private String certificateInstitution;
    private String carLevel;
    private String policyNumber;
    private String policyExpireDate;
    private String gpsStatus;
    private String carCheckYear;
    private String carCheckStatus;
    private String carCheckDate;
    private String carNextCheckDate;
    private String status;
    private String updateTime;
    private String dangerType;
    private String campanyName;

    private List<PersonInformation> personInformations;

    public List<PersonInformation> getPersonInformations() {
        return personInformations;
    }

    public void setPersonInformations(List<PersonInformation> personInformations) {
        this.personInformations = personInformations;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getBrandNumber() {
        return brandNumber;
    }

    public void setBrandNumber(String brandNumber) {
        this.brandNumber = brandNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarLimitSeat() {
        return carLimitSeat;
    }

    public void setCarLimitSeat(String carLimitSeat) {
        this.carLimitSeat = carLimitSeat;
    }

    public String getCarTonnage() {
        return carTonnage;
    }

    public void setCarTonnage(String carTonnage) {
        this.carTonnage = carTonnage;
    }

    public String getCarTractionMass() {
        return carTractionMass;
    }

    public void setCarTractionMass(String carTractionMass) {
        this.carTractionMass = carTractionMass;
    }

    public String getCarLength() {
        return carLength;
    }

    public void setCarLength(String carLength) {
        this.carLength = carLength;
    }

    public String getCarHigh() {
        return carHigh;
    }

    public void setCarHigh(String carHigh) {
        this.carHigh = carHigh;
    }

    public String getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(String carWidth) {
        this.carWidth = carWidth;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
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

    public String getCertificateInstitution() {
        return certificateInstitution;
    }

    public void setCertificateInstitution(String certificateInstitution) {
        this.certificateInstitution = certificateInstitution;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyExpireDate() {
        return policyExpireDate;
    }

    public void setPolicyExpireDate(String policyExpireDate) {
        this.policyExpireDate = policyExpireDate;
    }

    public String getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(String gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public String getCarCheckYear() {
        return carCheckYear;
    }

    public void setCarCheckYear(String carCheckYear) {
        this.carCheckYear = carCheckYear;
    }

    public String getCarCheckStatus() {
        return carCheckStatus;
    }

    public void setCarCheckStatus(String carCheckStatus) {
        this.carCheckStatus = carCheckStatus;
    }

    public String getCarCheckDate() {
        return carCheckDate;
    }

    public void setCarCheckDate(String carCheckDate) {
        this.carCheckDate = carCheckDate;
    }

    public String getCarNextCheckDate() {
        return carNextCheckDate;
    }

    public void setCarNextCheckDate(String carNextCheckDate) {
        this.carNextCheckDate = carNextCheckDate;
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

    public String getDangerType() {
        return dangerType;
    }

    public void setDangerType(String dangerType) {
        this.dangerType = dangerType;
    }

    public String getCampanyName() {
        return campanyName;
    }

    public void setCampanyName(String campanyName) {
        this.campanyName = campanyName;
    }

}
