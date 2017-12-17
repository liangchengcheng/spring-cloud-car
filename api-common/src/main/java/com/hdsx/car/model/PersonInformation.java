package com.hdsx.car.model;

import java.io.Serializable;

public class PersonInformation implements Serializable{

    private String societyId;
    private String name;
    private String gender;
    private String IDCardType;
    private String IDCardNumber;
    private String birthDate;
    private String campanyName;
    private String phoneNumber;
    private String updateTime;
    private String plateNumber;
    private String serverLevel;
    private String certificateStatus;
    private String carDriverType;

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

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCampanyName() {
        return campanyName;
    }

    public void setCampanyName(String campanyName) {
        this.campanyName = campanyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getServerLevel() {
        return serverLevel;
    }

    public void setServerLevel(String serverLevel) {
        this.serverLevel = serverLevel;
    }
}
