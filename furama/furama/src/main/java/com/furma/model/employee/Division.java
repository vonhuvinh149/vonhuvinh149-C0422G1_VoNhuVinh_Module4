package com.furma.model.employee;

import com.furma.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bo_phan")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bo_phan")
    private Integer idDivision;
    @Column(name = "ten_bo_phan")
    private String nameDivision ;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    private List<Employee> employees ;

    public Division() {
    }

    public Division(Integer idDivision, String nameDivision, List<Employee> employees) {
        this.idDivision = idDivision;
        this.nameDivision = nameDivision;
        this.employees = employees;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public String getNameDivision() {
        return nameDivision;
    }

    public void setNameDivision(String nameDivision) {
        this.nameDivision = nameDivision;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
