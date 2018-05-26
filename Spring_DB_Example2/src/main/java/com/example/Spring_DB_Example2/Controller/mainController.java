package com.example.Spring_DB_Example2.Controller;

import com.example.Spring_DB_Example2.Repository.Address;
import com.example.Spring_DB_Example2.Repository.Employee;
import com.example.Spring_DB_Example2.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sayali on 5/25/2018.
 */
@RestController
@Transactional
public class mainController {

    @Autowired
    EmployeeRepo employeeRepo;


    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("/findall")
    public List<Employee> findAll()
    {
        return (List<Employee>) employeeRepo.findAll();
    }

    @RequestMapping("/findid/{id}")
    public Employee findById(@PathVariable("id")String id)
    {
        return employeeRepo.findOne(Integer.parseInt(id));
    }

    @RequestMapping("/findidname/{id}/{name}")
    public List<Employee> findbyIDnName(@PathVariable("id")String id,@PathVariable("name")String name)
    {
        return employeeRepo.findByidAndFirstName(Integer.parseInt(id),name);
    }

    @RequestMapping("/delete/id")
    public String delete(@RequestParam("q")String id)
    {
        Employee e=employeeRepo.findOne(Integer.parseInt(id));
        employeeRepo.delete(e);
        return "Employee "+e.getFirstName()+" deleted";
    }
    @RequestMapping("/save/{firstname}/{salary}")
    public String save(@PathVariable("firstname")String firstname,@PathVariable("salary")String salary)
    {
        Employee employee=new Employee();
        employee.setFirstName(firstname);
        employee.setSalary(Float.parseFloat(salary));

        Address address=new Address();
        address.setCity("Kalyan");
        address.setStreet("RTO Road");
        address.setState("Maharashtra");

        List<Address> add1=new ArrayList<>();
        add1.add(address);
        address.setEmployee(employee);
        employee.setAddresses(add1);

        entityManager.persist(employee);
        entityManager.persist(address);
        return "Employee "+employee.getFirstName()+" is added with id ";
    }
}

