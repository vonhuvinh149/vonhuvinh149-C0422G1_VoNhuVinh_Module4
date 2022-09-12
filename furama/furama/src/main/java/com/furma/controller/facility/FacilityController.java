package com.furma.controller.facility;


import com.furma.model.facility.Facility;
import com.furma.model.facility.FacilityType;
import com.furma.model.facility.RentType;
import com.furma.service.facility.IFacilityTypeService;
import com.furma.service.facility.IRentTypeService;
import com.furma.service.facility.impl.FacilityService;
import dto.FacilityDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list_facility")
    public String listCustomer(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keywordFacility, Model model) {

        String facilityKeyword = keywordFacility.orElse("");
        Page<Facility> facilities = this.facilityService.findByNameFacilityContaining(facilityKeyword, pageable);

        model.addAttribute("facilityKeyword", keywordFacility);
        model.addAttribute("facility", facilities);

        return "/facility/list_facility";
    }


    @PostMapping("/delete")
    private String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {

        this.facilityService.deleteById(id);

        redirectAttributes.addFlashAttribute("msg", "xoá thành công");

        return "redirect:/facility/list_facility";

    }

    @GetMapping("/add")
    public String create(Model model) {
        List<RentType> rentTypes = this.rentTypeService.findAll();
        List<FacilityType> facilityTypes = this.facilityTypeService.findAll();
        FacilityDto facilityDto = new FacilityDto();
        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("rentType", rentTypes);
        model.addAttribute("facilityTypes", facilityTypes);

        return "facility/create_facility";
    }

    @PostMapping("/create")
    public String save(RedirectAttributes redirectAttributes, @ModelAttribute("facility") @Valid FacilityDto facilityDto , BindingResult bindingResult , Model model) {

        Facility facility = new Facility();

        new FacilityDto().validate(facilityDto , bindingResult);

        if (bindingResult.hasErrors()){
            return "facility/create_facility";
        }

        BeanUtils.copyProperties(facilityDto,facility);

        this.facilityService.save(facility);

        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");

        return "redirect:/facility/list_facility";
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {

        List<FacilityType> facilityTypes = this.facilityTypeService.findAll();
        List<RentType> rentTypes = this.rentTypeService.findAll();

        model.addAttribute("facility", this.facilityService.findById(id));
        model.addAttribute("facilityTypes", facilityTypes);
        model.addAttribute("rentType", rentTypes);

        return "facility/edit_facility";
    }

    @PostMapping("/update")
    public String update(Facility facility, RedirectAttributes redirectAttributes) {

        this.facilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg", "update thành công");

        return "redirect:/facility/list_facility";
    }

}
