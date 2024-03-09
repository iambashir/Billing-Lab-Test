package com.spring.feature.billing.lab.service;

import com.spring.feature.billing.lab.entity.Person;
import com.spring.feature.billing.lab.dto.PersonDto;
import com.spring.feature.billing.lab.dto.PersonRestDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface PersonService {
    PersonDto createPerson();

    Object savePerson(PersonDto personDto);

    void addContact(Person person);

    void removeContact(Person person, Integer contactIndex);

    List<PersonDto> getAllData(LocalDate date);

    Optional<Person> editPerson(Long id);

    void deletePerson(Long id);

    List<PersonRestDto> getBillBetweenDates(LocalDate startDate, LocalDate endDate);


    List<Person> dayTodayLimsData(LocalDate startDate, LocalDate endDate);

  List<PersonRestDto> getBillBetweenDatesAndDepartment(LocalDate startDate, LocalDate endDate, String department);
}
