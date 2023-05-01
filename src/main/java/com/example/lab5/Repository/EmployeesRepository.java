package com.example.lab5.Repository;

import com.example.lab5.DTO.SalariosDTO;
import com.example.lab5.Entity.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "SELECT e.* FROM employees e " +
            "INNER JOIN jobs j ON e.job_id = j.job_id " +
            "INNER JOIN departments d ON e.department_id = d.department_id " +
            "INNER JOIN locations l ON d.location_id = l.location_id " +
            "WHERE ((lower(e.first_name) like %?1% " +
            "OR lower(e.last_name) like %?1% " +
            "OR lower(j.job_title) like %?1% " +
            "OR lower(l.city) like %?1%) and enabled=1)",nativeQuery = true)
    List<Employees> buscarEmpleado(String buscando);

    @Transactional
    @Modifying
    @Query(value = "UPDATE departments SET manager_id=null where manager_id=?1", nativeQuery = true)
    void actualiza1(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees e SET enabled=0 where employee_id=?1", nativeQuery = true)
    void actualiza2(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET manager_id=null WHERE employee_id IN" +
            "       (SELECT employee_id FROM (SELECT employee_id FROM employees WHERE manager_id= ?1) AS subquery)", nativeQuery = true)
    void actualiza3(int id);


    @Query(value = "SELECT * FROM employees where enabled=1", nativeQuery = true)
    List<Employees> listado();


    @Query(value = "SELECT j.job_title as puesto, j.max_salary as maxsalario, j.min_salary as minsalario," +
            "       SUM(e.salary) as totalsalario, ROUND(AVG(e.salary),2) as promsalario" +
            " FROM employees e" +
            "         INNER JOIN jobs j ON e.job_id = j.job_id" +
            " GROUP BY j.job_id, j.job_title, j.max_salary, j.min_salary" +
            " ORDER BY j.job_id", nativeQuery = true)
    List<SalariosDTO> salariodto();

}