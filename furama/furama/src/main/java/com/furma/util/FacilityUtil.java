package com.furma.util;

import com.furma.dto.FacilityDto;
import org.springframework.validation.Errors;

public class FacilityUtil {

    public static void checkName(FacilityDto facilityDto, Errors errors) {

        if (!(facilityDto.getNameFacility() == null || facilityDto.getNameFacility().trim().equals(""))) {
            if (!facilityDto.getNameFacility().matches("^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+" +
                    "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)*$")) {
                errors.rejectValue("nameFacility", "name.err", "Please input right format!!!");
            }
        }
    }
}
