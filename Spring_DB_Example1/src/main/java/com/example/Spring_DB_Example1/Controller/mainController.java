package com.example.Spring_DB_Example1.Controller;

import com.example.Spring_DB_Example1.Repository.Employee;
import com.example.Spring_DB_Example1.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sayali on 5/25/2018.
 */
@RestController
public class mainController {

    @Autowired
    EmployeeRepo employeeRepo;


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
        employee= employeeRepo.save(employee);
        return "Employee "+employee.getFirstName()+" is added with id "+ employee.getId();
    }
}

