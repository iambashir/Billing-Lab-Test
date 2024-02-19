package com.spring.feature.billing.lab.service.impl;


import com.spring.feature.billing.lab.dto.PersonDto;
import com.spring.feature.billing.lab.dto.PersonRestDto;
import com.spring.feature.billing.lab.entity.Contact;
import com.spring.feature.billing.lab.entity.Person;
import com.spring.feature.billing.lab.enums.ActiveStatus;
import com.spring.feature.billing.lab.repository.PersonRepository;
import com.spring.feature.billing.lab.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public PersonDto createPerson() {
        Person persons = modelMapper.map(new PersonDto(), Person.class);
        return modelMapper.map(persons, PersonDto.class);
    }

    @Override
    public Object savePerson(PersonDto personDto) {
        Person person = modelMapper.map(personDto, Person.class);
        person.setActiveStatus(ActiveStatus.ACTIVE.getValue());
        personRepository.save(person);
        return null;
    }

    @Override
    public void addContact(Person person) {
        person.getLines().add(new Contact());
    }

    @Override
    public void removeContact(Person person, Integer contactIndex) {
        person.getLines().remove(contactIndex.intValue());
    }

    @Override
    public List<PersonDto> getAllData(LocalDate date) {
        List<Person> persons = personRepository.findByCreateDateBetweenAndActiveStatus(date, date,ActiveStatus.ACTIVE.getValue());
        return persons.stream().map(person -> modelMapper.map(person, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Person> editPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deletePerson(Long id) {
        Optional<Person> persons = personRepository.findById(id);
        Person person = persons.get();
//        Person person=new Person();
        person.setActiveStatus(ActiveStatus.INACTIVE.getValue());
        personRepository.save(person);
    }

    @Override
    public List<PersonRestDto> getBillBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Person> billBetween = personRepository.findByCreateDateBetweenAndActiveStatus(startDate, endDate,ActiveStatus.ACTIVE.getValue());
        return billBetween.stream().map(bills -> modelMapper.map(bills, PersonRestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> dayTodayLimsData(LocalDate startDate, LocalDate endDate) {
        List<Person> billBetween = personRepository.findByCreateDateBetweenAndActiveStatus(startDate, endDate,ActiveStatus.ACTIVE.getValue());

        return billBetween;
    }

}
