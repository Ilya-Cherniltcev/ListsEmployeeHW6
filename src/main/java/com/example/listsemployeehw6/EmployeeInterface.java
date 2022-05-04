package com.example.listsemployeehw6;

import java.util.List;

public interface EmployeeInterface {
    Employee addNewEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    List<Employee> printAllEmployees();

    void firstFillOfList();

}
