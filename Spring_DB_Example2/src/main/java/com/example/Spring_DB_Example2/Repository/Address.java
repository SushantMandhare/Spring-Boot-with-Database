package com.example.Spring_DB_Example2.Repository;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Sayali on 5/25/2018.
 */

@Component
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private String street;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

