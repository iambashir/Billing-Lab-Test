package com.spring.feature.billing.lab.repository;

import com.spring.feature.billing.lab.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByCreateDateBetweenAndActiveStatus(LocalDate startDate, LocalDate endDate,int status);

    List<Person>findAllByActiveStatus(int status);

}
