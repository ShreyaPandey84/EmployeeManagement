package com.kiet.employeemanagement;

import org.springframework.web.bind.annotation.*;
import java.util.*;

    @RestController
    public class EmployeeController {

        private List<Employee> employees = new ArrayList<>();

        @PostMapping("/employees")
        public Employee addEmployee(@RequestBody Employee employee) {
            employees.add(employee);
            return employee;
        }

        @GetMapping("/employees")
        public List<Employee> getAllEmployees() {
            return employees;
        }

        @GetMapping("/employees/{id}")
        public Employee getEmployeeById(@PathVariable int id) {
            for (Employee e : employees) {
                if (e.getId() == id) {
                    return e;
                }
            }
            return null;
        }

        @PutMapping("/employees/{id}")
        public Employee updateEmployee(
                @PathVariable int id,
                @RequestBody Employee updatedEmployee) {

            for (Employee e : employees) {
                if (e.getId() == id) {
                    e.setName(updatedEmployee.getName());
                    e.setDepartment(updatedEmployee.getDepartment());
                    e.setSalary(updatedEmployee.getSalary());
                    return e;
                }
            }
            return null;
        }

        @DeleteMapping("/employees/{id}")
        public String deleteEmployee(@PathVariable int id) {
            for (Employee e : employees) {
                if (e.getId() == id) {
                    employees.remove(e);
                    return "Employee deleted successfully";
                }
            }
            return "Employee not found";
        }
    }

