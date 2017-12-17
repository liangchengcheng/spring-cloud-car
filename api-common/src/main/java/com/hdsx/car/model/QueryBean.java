package com.hdsx.car.model;

import java.io.Serializable;

public class QueryBean implements Serializable{

    private CompanyRegist campany;
    private CarInformation car;
    private PersonInformation person;
    private Pagination pagination;

    public CompanyRegist getCampany() {
        return campany;
    }

    public void setCampany(CompanyRegist campany) {
        this.campany = campany;
    }

    public CarInformation getCar() {
        return car;
    }

    public void setCar(CarInformation car) {
        this.car = car;
    }

    public PersonInformation getPerson() {
        return person;
    }

    public void setPerson(PersonInformation person) {
        this.person = person;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
