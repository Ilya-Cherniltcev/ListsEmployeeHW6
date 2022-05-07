package com.example.listsemployeehw6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeInterface employeeService;

    public EmployeeController(EmployeeInterface employeeService) {
        this.employeeService = employeeService;
    }

    // ----------------------------------------------------------------------------
    // ++++++++  добавить сотрудника
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addNewEmployee(firstName, lastName);
    }

    // ???????????  найти сотрудника
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    // ----------  удалить сотрудника
    @GetMapping(path = "/remove")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    // ----------  распечатать всех сотрудников
    @GetMapping(path = "/printall")
    public List<Employee> printAll(@RequestParam(required = false) String s) {
        return employeeService.printAllEmployees();
    }

    // ----------  Первоначальное заполнение списка
    @GetMapping(path = "/fill")
    public List<Employee> firstFill(@RequestParam(required = false) String s) {
        return employeeService.firstFillOfList();
    }
}