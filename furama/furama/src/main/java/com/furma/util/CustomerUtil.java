package com.furma.util;

import dto.CustomerDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class CustomerUtil {


    public static void checkName(CustomerDto customerDto, Errors errors) {

        if (!(customerDto.getName() == null || customerDto.getName().trim().equals(""))) {
            if (!customerDto.getName().matches("^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+" +
                    "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)*$")) {
                errors.rejectValue("name", "name.err", "Please input right format!!! ex: Võ Như Vinh");
            }
        }
    }

    public static void checkAge(CustomerDto customerDto, Errors errors) {
        LocalDate now = LocalDate.now();

        LocalDate dayOfBirth = null;

        try {
            dayOfBirth = LocalDate.parse(customerDto.getDateOfBirth());
            if (Period.between(dayOfBirth, now).getYears() < 18) {
                errors.rejectValue("age", "create.age", "khong duoc nho hon 18 tuoi");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "create.age", "vui long nhap");
        }
    }
}

