package com.example.listsemployeehw6;

import com.example.listsemployeehw6.exceptions.AlreadyExistsException;
import com.example.listsemployeehw6.exceptions.EmployeeNotFoundException;
import com.example.listsemployeehw6.exceptions.OverArrayException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService implements EmployeeInterface {
    private int sizeList = 4;
    private List<Employee> empl = new ArrayList(sizeList);

    // +++++++++++++++++++++++ Добавляем нового сотрудника +++++++++++++++++++++++++++
    public Employee addNewEmployee(String firstName, String lastName) {
        final Employee employee = new Employee(firstName, lastName);
        if (empl.contains(employee)) {
            // =====   работник уже есть в базе, вызываем ошибку 400 Bad Request =======
            throw new AlreadyExistsException();
        }
        // ===  добавляем нового работника в массив
        empl.add(employee);
        // ===  проверяем, увеличился ли размер списка по сравнению с первоначальным.
        // ===  Если это так, то удаляем излишне добавленный элемент и
        // =====   вызываем ошибку 500 Internal Server Error =======
        if (empl.size() > sizeList) {
            empl.remove(employee);
            throw new OverArrayException();
        }
        return employee;
    }

    // ----------------- Находим сотрудника по Ф.И.О. ------------------------------------
    public Employee findEmployee(String firstName, String lastName) {
        final Employee employee = new Employee(firstName, lastName);
        if (empl.contains(employee)) {
            return employee;
        } else {
            // =====   сотрудник не найден, вызываем ошибку 404 Not Found =======
            throw new EmployeeNotFoundException();
        }
    }

    // ----------------- Удаляем сотрудника по Ф.И.О. ------------------------------------
    public Employee deleteEmployee(String firstName, String lastName) {
        final Employee employee = findEmployee(firstName, lastName);
        empl.remove(employee);
        return employee;
    }

    // ----------------- Печатаем информацию обо всех сотрудниках ------------------------------------
    public List<Employee> printAllEmployees() {
        return empl;
    }

    // +++++++++++++++++ Заполняем список сотрудниками +++++++++++++++++++++++++++++
    public List<Employee> firstFillOfList() {
        Employee[] e = {
                new Employee("Oleg", "Krylov"),
                new Employee("Ivan", "Ivanov"),
                new Employee("Petr", "Petrov")};
        if (empl.isEmpty()) {
            for (int i = 0; i < sizeList - 1; i++) {
                empl.add(e[i]);
            }
        }
        return empl;
    }
}
