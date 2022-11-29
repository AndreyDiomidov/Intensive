package net.proselyte.employeemanager.dao;

import net.proselyte.employeemanager.model.employee;

import java.util.List;

public interface EmployeeDao {
    public void addEmployee(employee employee);
    public void updateEmployee(employee employee);
    public void removeEmployee (int id);
    public employee getEmployeeById(int id);
    public List<employee> listEmployee();


}
