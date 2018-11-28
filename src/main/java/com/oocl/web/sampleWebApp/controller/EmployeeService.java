package com.oocl.web.sampleWebApp.controller;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class EmployeeService {
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    List<Employee> employees = new ArrayList<>();


    public void addEmployee(Employee employee) {
        Employee.setCount(Employee.getCount()+1);
        employees.add(employee);
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId()==id) {
                return employee;
            }
        }
        return null;
    }


}
