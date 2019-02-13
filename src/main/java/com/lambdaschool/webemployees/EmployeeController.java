package com.lambdaschool.webemployees;

//localhost:8000/data/allemployees

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class EmployeeController {
    @RequestMapping("/employee")
    public Employee getEmployeeDetail(@RequestParam(value = "id") long id) {
        return WebemployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == id));
    }

    @RequestMapping("/allEmployees")
    public ArrayList<Employee> getALlEmployees() {
        WebemployeesApplication.ourEmpList.empList.sort((e1, e2) ->
                e1.getName().compareToIgnoreCase(e2.getName()));
        return WebemployeesApplication.ourEmpList.empList;
    }
}
