package com.furma.model.contract;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "hop_dong_chi_tiet")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private Integer idContract;
    @Column(name = "so_luong")
    private Integer quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ma_hop_dong" ,referencedColumnName = "ma_hop_dong")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem")
    private AttachFacility attachFacility;

    public ContractDetail(Integer idContract, Integer quantity, Contract contract, AttachFacility attachFacility) {
        this.idContract = idContract;
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public ContractDetail() {
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
