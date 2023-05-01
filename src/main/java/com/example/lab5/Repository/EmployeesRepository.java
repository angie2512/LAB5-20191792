package com.example.lab5.Repository;

import com.example.lab5.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "SELECT e.* FROM employees e " +
            "INNER JOIN jobs j ON e.job_id = j.job_id " +
            "INNER JOIN departments d ON e.department_id = d.department_id " +
            "INNER JOIN locations l ON d.location_id = l.location_id " +
            "WHERE (lower(e.first_name) like %?1% " +
            "OR lower(e.last_name) like %?1% " +
            "OR lower(j.job_title) like %?1% " +
            "OR lower(l.city) like %?1%)",nativeQuery = true)
    List<Employees> buscarEmpleado(String buscando);


    @Query("SELECT e FROM Employees e " +
            "INNER JOIN e.job j " +
            "INNER JOIN e.department d " +
            "INNER JOIN d.location l " +
            "WHERE e.lastName LIKE CONCAT('%', ?1, '%') "+
            "OR j.jobTitle LIKE CONCAT('%', ?1, '%') "+
            "or d.departmentName LIKE CONCAT('%', ?1, '%') "+
            "OR l.city LIKE CONCAT('%', ?1, '%') ")
    List<Employees> test2(String searchTerm);

    @Query("SELECT e FROM Employees e " +
            "INNER JOIN e.job j " +
            "INNER JOIN e.department d " +
            "INNER JOIN d.location l " +
            "WHERE e.lastName LIKE %?1% "+
            "OR j.jobTitle LIKE %?1% "+
            "or d.departmentName LIKE  %?1% "+
            "OR l.city LIKE  %?1% ")
    List<Employees> testeee(String searchTerm);

}