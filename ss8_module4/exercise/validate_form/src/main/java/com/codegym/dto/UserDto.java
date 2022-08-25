package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {
    @NotBlank
    @Pattern(regexp = "[A-Za-z ]+", message = "vui long nhap dung dinh dang ")
    private String firstName;

    @NotBlank(message = "vui long nhap")
    @Pattern(regexp = "[A-Za-z]+", message = "vui long nhap dung dinh dang ")
    private String lastName;

    @NotBlank(message = "vui long nhap")
    @Pattern(regexp = "((\\+84)|[0])[0-9]{9}", message = "vui long nhap dung dinh dang")
    private String phoneNumber;

    private String age;

    @NotBlank
    @Email(message = "nhap sai dinh dang")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        LocalDate now = LocalDate.now();

        LocalDate dayOfBirth = null;

        try {
            dayOfBirth = LocalDate.parse(userDto.age);
            if (Period.between(dayOfBirth,now).getYears() < 18){
                errors.rejectValue("age","create.age","khong duoc nho hon 18 tuoi");
            }
        } catch (Exception e) {
            errors.rejectValue("age","create.age","vui long nhap");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
