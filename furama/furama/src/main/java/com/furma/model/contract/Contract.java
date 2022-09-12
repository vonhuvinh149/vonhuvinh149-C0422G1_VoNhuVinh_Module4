package com.furma.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.furma.model.customer.Customer;
import com.furma.model.employee.Employee;
import com.furma.model.facility.Facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hop_dong")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Integer idContract;
    @Column(name = "ngay_lam_hop_dong")
    private String startDate;
    @Column(name = "ngay_ket_thuc")
    private String endDate;
    @Column(name = "tien_dat_coc")
    private Double deposit;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    List<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu")
    private Facility facility ;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private Employee employee ;

    public Contract(Integer idContract, String startDate, String endDate, Double deposit, List<ContractDetail> contractDetails, Customer customer, Facility facility) {
        this.idContract = idContract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.contractDetails = contractDetails;
        this.customer = customer;
        this.facility = facility;
    }

    public Contract() {
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
