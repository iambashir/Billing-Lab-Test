package com.spring.feature.frontend;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface PersonService {
    PersonDto createPerson();

    Object savePerson(PersonDto personDto);

    void addContact(Person person);

    void removeContact(Person person, Integer contactIndex);

    List<PersonDto> getAllData();

    Optional<Person> editPerson(Long id);

    void deletePerson(Long id);

    List<PersonRestDto> getBillBetweenDates(LocalDate startDate, LocalDate endDate);


}
