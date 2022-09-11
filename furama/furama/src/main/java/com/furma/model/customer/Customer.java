package com.furma.model.customer;
import com.furma.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name = "khach_hang")
    public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ma_khach_hang")
        private Integer id;
        @Column(name = "ho_ten")
        private String name;
        @Column(name = "ngay_sinh")
        private String dateOfBirth;
        @Column(name = "gioi_tinh")
        private String gender;
        @Column(name = "so_cmnd")
        private String idCard;
        @Column(name = "so_dien_thoai")
        private String phoneNumber;
        @Column(name = "email")
        private String email;
        @Column(name = "dia_chi")
        private String address;

        @ManyToOne
        @JoinColumn(name = "ma_loai_khach", referencedColumnName = "ma_loai_khach")
        private CustomerType customerType;

        @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
        private List<Contract>  contracts ;

    public Customer(Integer id, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
