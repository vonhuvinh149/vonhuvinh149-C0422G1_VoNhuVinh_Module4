package com.furma.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vi_tri")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private Integer idPosition;
    @Column(name = "ten_vi_tri")
    private String namePosition;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Position() {
    }

    public Position(Integer idPosition, String namePosition, List<Employee> employees) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.employees = employees;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
