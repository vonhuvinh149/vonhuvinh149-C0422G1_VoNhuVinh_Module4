package com.furma.model.facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_dich_vu")
    private Integer idFacilityType;
    @Column(name = "ten_loai_dich_vu")
    private String nameFacilityType;

    @OneToMany(mappedBy = "facilityType",cascade = CascadeType.ALL)
    List<Facility> facilities;

    public FacilityType(Integer idFacilityType, String nameFacilityType, List<Facility> facilities) {
        this.idFacilityType = idFacilityType;
        this.nameFacilityType = nameFacilityType;
        this.facilities = facilities;
    }

    public FacilityType() {
    }

    public Integer getIdFacilityType() {
        return idFacilityType;
    }

    public void setIdFacilityType(Integer idFacilityType) {
        this.idFacilityType = idFacilityType;
    }

    public String getNameFacilityType() {
        return nameFacilityType;
    }

    public void setNameFacilityType(String nameFacilityType) {
        this.nameFacilityType = nameFacilityType;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
