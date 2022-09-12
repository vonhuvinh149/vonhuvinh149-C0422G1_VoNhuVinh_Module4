package com.furma.util;

import dto.CustomerDto;
import dto.FacilityDto;
import org.springframework.validation.Errors;

public class FacilityUtil {

    public static void checkName(FacilityDto facilityDto, Errors errors) {

        if (!(facilityDto.getNameFacility() == null || facilityDto.getNameFacility().trim().equals(""))) {
            if (!facilityDto.getNameFacility().matches("^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+" +
                    "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)*$")) {
                errors.rejectValue("name", "name.err", "Please input right format!!! ex: Võ Như Vinh");
            }
        }
    }

    public static void checkDouble(FacilityDto facilityDto , Errors errors){
        if (facilityDto.getPoolArea() < 0 || facilityDto.getArea() < 0 ){
        errors.rejectValue("area","Create.area","Không được âm");
        }
    }
}
