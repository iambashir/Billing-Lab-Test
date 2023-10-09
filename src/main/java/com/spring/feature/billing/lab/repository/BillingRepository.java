package com.spring.feature.billing.lab.repository;

import com.spring.feature.billing.lab.entity.BillingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<BillingModel, Long> {

    /**------- Get employee between dates ------*/
    List<BillingModel> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);
    /*List<BillingModel> findByCreate_dateBetween(LocalDate startDate, LocalDate endDate);*/

    /*@Query(value = "SELECT * FROM billing WHERE create_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<BillingModel> findBillingModelsBetweenDates(LocalDate startDate, LocalDate endDate);*/

}
