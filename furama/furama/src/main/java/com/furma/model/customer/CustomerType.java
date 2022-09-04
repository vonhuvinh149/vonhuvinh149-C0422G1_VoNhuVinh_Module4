package com.furma.model.customer;

import com.furma.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_khach")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_khach")
    private Integer customer_type_id;
    @Column(name = "ten_loai_khach")
    private String customer_type_name;

    @OneToMany(mappedBy = "customerType")
    List<Customer> customers;


    public CustomerType() {
    }

    public CustomerType(Integer customer_type_id, String customer_type_name, List<Customer> customers) {
        this.customer_type_id = customer_type_id;
        this.customer_type_name = customer_type_name;
        this.customers = customers;
    }

    public Integer getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(Integer customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
