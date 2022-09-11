package com.furma.controller.contract;

import com.furma.model.contract.Contract;
import com.furma.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService ;

    @GetMapping("/customer_use_facility")
    public String customerUserFacility(@PageableDefault(size = 2) Pageable pageable,
                                       @RequestParam Optional<String> nameCustomer, Model model,@RequestParam (defaultValue = "") String day) {

       String nameCustomers = nameCustomer.orElse("");
        Page<Contract> contracts = this.contractService.findAllByEndDateGreaterThanAndCustomer_NameContaining(day,nameCustomers,pageable);
        model.addAttribute("contracts",contracts);
        model.addAttribute("days",day);

        return "/contract/customer_use_facility";
    }

}
