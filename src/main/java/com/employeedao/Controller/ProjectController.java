package com.employeedao.Controller;




import com.employeedao.Model.Project;
import com.employeedao.Model.Employe;
import com.employeedao.DAO.EmployeeDAO;
import com.employeedao.DAO.ProjectDAO;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;

import java.util.List;

@ManagedBean
@RequestScoped
public class ProjectController {
    @ManagedProperty("#{projectDAO}")
    private ProjectDAO projectDAO;

    @ManagedProperty("#{employeeDAO}")
    private EmployeeDAO employeeDAO;

    private Project project = new Project();
    private List<Project> projects;
    private List<Employe> employees;

    private Employe selecEmployee;
    private Project selecProject;

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Employe> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employe> employees) {
        this.employees = employees;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employe getSelectedEmployee() {
        return selecEmployee;
    }

    public void setSelectedEmployee(Employe selectedEmployee) {
        this.selecEmployee = selectedEmployee;
    }

    public Project getSelectedProject() {
        return selecProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selecProject = selectedProject;
    }

    public String saveProject() {
        projectDAO.createProject(project);
        return "project-list?faces-redirect=true"
    }

    public void loadProjects() {
        projects = projectDAO.getAllProjects();
    }

    public void loadEmployees() {
        employees = employeeDAO.getAllEmployees();
    }

}
