package com.oocl.web.sampleWebApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @PostMapping(path = "/{name}", produces = {"application/json"})
    public ResponseEntity<String> add(@PathVariable String name) {
        Employee newEmployee = new Employee(name, 1, "Male", 1000);
        service.addEmployee(newEmployee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",  "employees/" + newEmployee.getName());
        return new ResponseEntity<String>("Success", headers, HttpStatus.CREATED);
    }
}