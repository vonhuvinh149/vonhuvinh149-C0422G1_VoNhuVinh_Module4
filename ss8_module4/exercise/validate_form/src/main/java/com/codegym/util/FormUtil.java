package com.codegym.util;

import com.codegym.dto.UserDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class FormUtil {

    public static void checkAge(UserDto userDto, Errors errors) {
        LocalDate now = LocalDate.now();

        LocalDate dayOfBirth = null;

        try {
            dayOfBirth = LocalDate.parse(userDto.getAge());
            if (Period.between(dayOfBirth, now).getYears() < 18) {
                errors.rejectValue("age","create.age","khong duoc nho hon 18 tuoi");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "create.age", "vui long nhap");
        }
    }
}
