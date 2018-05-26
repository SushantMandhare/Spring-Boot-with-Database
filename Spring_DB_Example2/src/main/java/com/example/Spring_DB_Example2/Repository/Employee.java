package com.example.Spring_DB_Example2.Repository;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sayali on 5/25/2018.
 */

@Component
@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "salary")
    private float Salary;

    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }
}
