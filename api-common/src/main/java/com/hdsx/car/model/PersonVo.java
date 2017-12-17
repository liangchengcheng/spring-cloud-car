package com.hdsx.car.model;

import java.io.Serializable;

public class PersonVo implements Serializable{
    private PersonInformation personInformation;
    private PersonQualification personQualification;
    private PersonEducation personEducation;

    public PersonVo() {
        super();
    }

    public PersonVo(PersonInformation personInformation, PersonQualification personQualification,
                    PersonEducation personEducation) {
        super();
        this.personInformation = personInformation;
        this.personQualification = personQualification;
        this.personEducation = personEducation;
    }

    public PersonInformation getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(PersonInformation personInformation) {
        this.personInformation = personInformation;
    }

    public PersonQualification getPersonQualification() {
        return personQualification;
    }

    public void setPersonQualification(PersonQualification personQualification) {
        this.personQualification = personQualification;
    }

    public PersonEducation getPersonEducation() {
        return personEducation;
    }

    public void setPersonEducation(PersonEducation personEducation) {
        this.personEducation = personEducation;
    }

}
