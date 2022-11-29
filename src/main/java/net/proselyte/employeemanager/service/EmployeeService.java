package net.proselyte.employeemanager.service;

import net.proselyte.employeemanager.model.employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee (employee employe);
    public void updateEmployee (employee employee);
    public void removeEmployee (int id);
    public employee getEmployeeById (int id);
    public List<employee> listEmployee();

}
