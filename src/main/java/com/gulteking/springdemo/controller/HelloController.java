package com.gulteking.springdemo.controller;

import com.gulteking.springdemo.model.AgeRequest;
import com.gulteking.springdemo.model.AgeResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;

@RestController
public class HelloController {

    @GetMapping("/welcome")
    public String sayHello(@RequestParam(name = "first_name", required = false, defaultValue = "noName") String clientName,
                           @RequestParam(name = "surname") String clientSurname) {
        return "Hello " + clientName + " " + clientSurname;
    }

    @PostMapping("/welcome")
    public AgeResponse calculateAge(@RequestBody @Valid AgeRequest ageRequest) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        int age = currentYear - ageRequest.getBirthYear();

        AgeResponse response = new AgeResponse();
        response.setAge(age);

        return response;
    }

    @GetMapping("/welcome/{name}/{birthYear}")
    public AgeResponse calculateAgeWithPath(@PathVariable String name, @PathVariable Integer birthYear) {
        System.out.println("NAME: " + name);
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        int age = currentYear - birthYear;

        AgeResponse response = new AgeResponse();
        response.setAge(age);

        return response;
    }

}
