package com.furma.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu_di_kem")
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer idAttachFacility;
    @Column(name = "ten_dich_vu_di_kem")
    private String nameAttachFacility;
    @Column(name = "gia")
    private Double cost;
    @Column(name = "don_vi")
    private String unit;
    @Column(name = "trang_thai")
    private String status;

    @OneToMany(mappedBy = "attachFacility", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ContractDetail> contractDetails;

    public AttachFacility(Integer idAttachFacility, String nameAttachFacility, Double cost, String unit, String status, List<ContractDetail> contractDetails) {
        this.idAttachFacility = idAttachFacility;
        this.nameAttachFacility = nameAttachFacility;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public AttachFacility() {
    }

    public Integer getIdAttachFacility() {
        return idAttachFacility;
    }

    public void setIdAttachFacility(Integer idAttachFacility) {
        this.idAttachFacility = idAttachFacility;
    }

    public String getNameAttachFacility() {
        return nameAttachFacility;
    }

    public void setNameAttachFacility(String nameAttachFacility) {
        this.nameAttachFacility = nameAttachFacility;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
