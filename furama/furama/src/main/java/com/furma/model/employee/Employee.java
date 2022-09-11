package com.furma.model.employee;


import com.furma.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhan_vien")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer idEmployee;
    @Column(name = "ho_ten")
    private String nameEmployee;
    @Column(name = "ngay_sinh")
    private String dateOfBirth;
    @Column(name = "so_cmnd")
    private String idCard;
    @Column(name = "luong")
    private Double salary;
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "dia_chi")
    private String address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do")
    private EducationDegree educationDegree;

    public Employee() {
    }

    public Employee(Integer idEmployee, String nameEmployee, String dateOfBirth, String idCard, Double salary, String phoneNumber, String email, String address, List<Contract> contracts, Position position, Division division, EducationDegree educationDegree) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.contracts = contracts;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
