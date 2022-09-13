package com.furma.controller.contract;


import com.furma.model.contract.Contract;
import com.furma.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/restContract")
public class RestContractController {

    @Autowired
    private IContractService contractService;


    @GetMapping("/listContract")
    public ResponseEntity<Page<Contract>> getContracts(@PageableDefault(size = 2) Pageable pageable,
                                                       @RequestParam Optional<String> nameCustomer) {

        String names = nameCustomer.orElse("");
        String day = String.valueOf(LocalDate.now());

        Page<Contract> contracts = this.contractService.findAllByEndDateGreaterThanAndCustomer_NameContaining(day, names, pageable);

        if (!contracts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(contracts, HttpStatus.OK);

    }
}
