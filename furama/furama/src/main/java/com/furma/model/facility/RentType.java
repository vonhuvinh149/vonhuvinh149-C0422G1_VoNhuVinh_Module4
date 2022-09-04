package com.furma.model.facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kieu_thue")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kieu_thue")
    private Integer idRentType;
    @Column(name = "ten_kieu_thue")
    private String nameRentType;


    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private List<Facility> facilities;

    public RentType(Integer idRentType, String nameRentType, List<Facility> facilities) {
        this.idRentType = idRentType;
        this.nameRentType = nameRentType;
        this.facilities = facilities;
    }

    public RentType() {
    }

    public Integer getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(Integer idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
