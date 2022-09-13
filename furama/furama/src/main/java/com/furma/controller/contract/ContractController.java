package com.furma.controller.contract;

import com.furma.dto.ContractDto;
import com.furma.model.contract.Contract;
import com.furma.model.customer.Customer;
import com.furma.model.facility.Facility;
import com.furma.service.contract.IContractService;
import com.furma.service.customer.ICustomerService;
import com.furma.service.facility.IFacilityService;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("/customer_use_facility")
    public String customerUserFacility(@PageableDefault(size = 2) Pageable pageable,
                                       @RequestParam Optional<String> nameCustomer, Model model) {
        Contract contractModel = new Contract();
        String nameCustomers = nameCustomer.orElse("");
        Page<Customer> customer = this.customerService.findAll(pageable);
        Page<Facility> facilities = this.facilityService.findAll(pageable);
        model.addAttribute("customer", customer);
        model.addAttribute("facilities", facilities);
        Page<Contract> contracts = this.contractService.findAllByEndDateGreaterThanAndCustomer_NameContaining(String.valueOf(LocalDate.now()), nameCustomers, pageable);
        model.addAttribute("contracts", contracts);
        model.addAttribute("days",  String.valueOf(LocalDate.now()));
        model.addAttribute("contractModel", contractModel);

        return "/contract/customer_use_facility";
    }

    @PostMapping("/createContract")
    public String createContract(@ModelAttribute("contractDto") @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "redirect:/contract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        Facility facility = new Facility();
        facility.setId(contractDto.getFacility().getId());
        contract.setFacility(facility);

        Customer customer = new Customer();
        customer.setId(contractDto.getCustomer().getId());
        contract.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(contractDto.getEmployee().getId());
        contract.setEmployee(employee);

        contractService.create(contract);
        redirectAttributes.addFlashAttribute("mess", "thêm hợp đồng thành công");
        return "redirect:/contract";
    }



}
