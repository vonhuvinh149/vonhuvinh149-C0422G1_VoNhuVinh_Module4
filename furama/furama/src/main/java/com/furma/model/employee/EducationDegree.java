package com.furma.model.employee;


import com.furma.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trinh_do")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_trinh_do")
    private Integer idEducationDegree ;
    @Column(name = "ten_trinh_do")
    private String nameEducationDegree ;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    private List<Employee> employees ;

    public EducationDegree() {
    }

    public EducationDegree(Integer idEducationDegree, String nameEducationDegree, List<Employee> employees) {
        this.idEducationDegree = idEducationDegree;
        this.nameEducationDegree = nameEducationDegree;
        this.employees = employees;
    }

    public Integer getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(Integer idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getNameEducationDegree() {
        return nameEducationDegree;
    }

    public void setNameEducationDegree(String nameEducationDegree) {
        this.nameEducationDegree = nameEducationDegree;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
