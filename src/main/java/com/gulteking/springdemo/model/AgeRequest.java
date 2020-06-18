package com.gulteking.springdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class AgeRequest {

    @NotBlank
    @Size(min = 2,max =255 )
    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String surname;


    @NotNull
    @Min(1900)
    @Max(2020)
    @JsonProperty(value = "birth_year")
    private Integer birthYear;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
}
