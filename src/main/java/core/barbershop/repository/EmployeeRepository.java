package core.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import core.barbershop.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

}