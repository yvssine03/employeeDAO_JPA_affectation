package com.employeedao.Controller;

import com.employeedao.DAO.EmployeeDAOImpl;
import com.employeedao.DAO.

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "employeeController")
@SessionScoped
public class EmployeeController {

    private final EmployeeDAOImpl employeeDAO;
    private Employe Employe;
    private List<Employe> employees;

    public EmployeeController() {
        employeeDAO = new EmployeeDAOImpl();
        employee = new Employee();
    }

    public void addEmployee() {
        employeeDAO.addEmployee(employee);
        employee = new Employe();
    }

    public void updateEmployee() {
        employeeDAO.updateEmployee(employee);
        employee = new Employee();
    }

    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    // Getters and setters for employee and employees
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
