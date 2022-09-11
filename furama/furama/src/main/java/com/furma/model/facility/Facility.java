package com.furma.model.facility;

import com.furma.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Integer idFacility;

    @Column(name = "ten_dich_vu")
    private String nameFacility;

    @Column(name = "dien_tich")
    private Double area;

    @Column(name = "chi_phi_thue")
    private Double cost;

    @Column(name = "so_nguoi_toi_da")
    private Integer maxPeople;


    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu")
    private FacilityType facilityType;

    @Column(name = "tieu_chuan_phong")
    private String standardRoom;
    @Column(name = "mo_ta_tien_nghi_khac")
    private String description;

    @Column(name = "dien_tich_ho_boi")
    private Double poolArea;

    @Column(name = "so_tang")
    private Integer numberFloors;

    @Column(name = "dich_vu_mien_phi_di_kem")
    private String facilityFree;

    @OneToMany(mappedBy = "facility", cascade = CascadeType.ALL)
    private List<Contract> contracts;


    public Facility(Integer idFacility, String nameFacility, Double area, Double cost, Integer maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String description, Double poolArea, Integer numberFloors, String facilityFree, List<Contract> contracts) {
        this.idFacility = idFacility;
        this.nameFacility = nameFacility;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.contracts = contracts;
    }

    public Facility() {
    }

    public Integer getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Integer idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
