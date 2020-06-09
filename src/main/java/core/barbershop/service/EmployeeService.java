package core.barbershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.barbershop.model.Employee;
import core.barbershop.repository.EmployeeRepository;

/**
 * EmployeeService
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee) {
        if (!employee.isValid()) {
            throw new Error("Invalid employee");
        }

        Employee newEmployee = this.employeeRepository.save(employee);

        return newEmployee;
    }

    public List<Employee> findAllEmployee() {
      List<Employee> employees = this.employeeRepository.findAll();

      return employees;
    }

    public Employee getEmployee(int id)
    {
        Employee employee = this.employeeRepository.getOne(id);

        return employee;
    }

    public void deleteEmployee(int id)
    {
        this.employeeRepository.deleteById(id);
    }
}