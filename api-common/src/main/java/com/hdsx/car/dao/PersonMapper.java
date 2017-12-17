package com.hdsx.car.dao;

import com.hdsx.car.model.PersonEducation;
import com.hdsx.car.model.PersonInformation;
import com.hdsx.car.model.PersonQualification;
import com.hdsx.car.model.QueryBean;

import java.util.List;

public interface PersonMapper {

    List<PersonInformation> getList(QueryBean queryBean);

    int getTotal(QueryBean queryBean);

    int addPersonInformation(PersonInformation personInformation);

    int addPersonQualification(PersonQualification personQualification);

    int addPersonEducation(PersonEducation personEducation);

    int updatePersonInformation(PersonInformation personInformation);

    int updatePersonQualification(PersonQualification personQualification);

    int updatePersonEducation(PersonEducation personEducation);

    int deletePersonInformation(PersonInformation personInformation);

    int deletePersonQualification(PersonInformation personInformation);

    int deletePersonEducation(PersonInformation personInformation);

    PersonInformation getPersonInformation(PersonInformation personInformation);

    PersonQualification getPersonQualification(PersonInformation personInformation);

    PersonEducation getPersonEducation(PersonInformation personInformation);
}
