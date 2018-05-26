package com.example.Spring_DB_Example2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sayali on 5/25/2018.
 */

@Component
@Repository
@Transactional
public interface EmployeeRepo extends CrudRepository<Employee,Integer>{
    List<Employee> findByidAndFirstName(int id, String firstName);
}
