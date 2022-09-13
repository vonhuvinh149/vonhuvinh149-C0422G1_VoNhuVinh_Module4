package com.furma.controller.customer;

import com.furma.model.customer.Customer;
import com.furma.model.customer.CustomerType;
import com.furma.service.customer.ICustomerService;
import com.furma.service.customer.ICustomerTypeService;
import com.furma.dto.CustomerDto;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customeService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/customer_list")
    public String listCustomer(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model) {

        String keywordVal = keyword.orElse("");
        Page<Customer> customers = this.customeService.findByNameContaining(keywordVal, pageable);
        model.addAttribute("keyword", keywordVal);
        model.addAttribute("customer", customers);

        return "/customer/list_customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {

        this.customeService.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "xoá thành công");

        return "redirect:/customer/customer_list";
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("customer", new CustomerDto());
        List<CustomerType> customerTypes = this.customerTypeService.findAll();
        model.addAttribute("customerTypesList", customerTypes);

        return "/customer/create_customer";
    }

    @PostMapping("/create")

    public String save(@ModelAttribute("customer") @Valid CustomerDto customerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {

        new CustomerDto().validate(customerDto, bindingResult);

        Customer customer = new Customer();

        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypes = this.customerTypeService.findAll();
            model.addAttribute("customerTypesList", customerTypes);
            return "/customer/create_customer";
        }

        BeanUtils.copyProperties(customerDto , customer);

        this.customeService.save(customer);

        redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");

        return "redirect:/customer/customer_list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        model.addAttribute("customer", this.customeService.findById(id));
        List<CustomerType> customerTypes = this.customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);

        return "/customer/edit_customer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {

        this.customeService.save(customer);

        redirectAttributes.addFlashAttribute("msg", "sửa thành công");

        return "redirect:/customer/customer_list";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id,Model model ) {

        Customer customer = this.customeService.findById(id);
        model.addAttribute("customer",customer);

        return "/customer/detail_customer";
    }
}
