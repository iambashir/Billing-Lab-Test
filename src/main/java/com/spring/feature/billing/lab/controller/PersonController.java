package com.spring.feature.billing.lab.controller;


import com.spring.feature.billing.lab.entity.Person;
import com.spring.feature.billing.lab.dto.PersonDto;
import com.spring.feature.billing.lab.dto.PersonRestDto;
import com.spring.feature.billing.lab.service.PersonService;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@Controller
public class PersonController {

    private static final Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("person", personService.createPerson());
        //logger.info("Error message: {}", "");
        return "index";
    }


    @GetMapping("/get")
    public String allData(Model model) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(currentDate.format(dateFormat));
        model.addAttribute("collectedDate", date);

        //======== 3 Days early date =========//
        LocalDate today = LocalDate.now();
        LocalDate earlyDate = today.plusDays(-3);
        model.addAttribute("syncDate1", earlyDate);

        model.addAttribute("getAllData", personService.getAllData(date));
        return "list";
    }

    @PostMapping("/get")
    public String dayTodayLimsData(Model model,
        @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("collectionDate") String fromdate,
        @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("collectionDate2") String toDate){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

        String date = currentDate.format(dateFormat);
        model.addAttribute("collectedDate", date);

        //======== 3 Days early date =========//
        LocalDate today = LocalDate.now();
        LocalDate earlyDate = today.plusDays(-3);
        model.addAttribute("syncDate1", earlyDate);

        List<Person> personList = personService.dayTodayLimsData(
            LocalDate.parse(fromdate, dateFormat), LocalDate.parse(toDate, dateFormat));
        model.addAttribute("getAllData", personList);

        return "list";
    }


    @PostMapping("/addContact")
    public String addContact(Person person) {
        personService.addContact(person);
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/removeContact")
    public String removeContact(Person person, @RequestParam("removeContact") Integer contactIndex) {
        personService.removeContact(person, contactIndex);
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/save")
    public String save(@Valid PersonDto personDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "The submitted data has errors.");
        } else {
            model.addAttribute("person", personService.savePerson(personDto));
            model.addAttribute("successMessage", "Person saved successfully!");
        }

        return "redirect:/get";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            //Optional<Person> person = personService.editPerson(id);
            //model.addAttribute("person", person);
            personService.editPerson(id).ifPresent(o -> model.addAttribute("person", o));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "edit";
    }


    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/get";

    }


    /**
     * ------- Get employee between dates ------
     */
    @GetMapping("/get/lab/data/{startDate}/{endDate}")
    @ResponseBody
    public ResponseEntity<List<PersonRestDto>> getBillBetweenDates(
            /**------ @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") -----**/
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        try {
            List<PersonRestDto> bills = personService.getBillBetweenDates(startDate, endDate);
            return new ResponseEntity<>(bills, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


