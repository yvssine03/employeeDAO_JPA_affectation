package com.employeedao.DAO;



import com.employeedao.Model.Project;
import java.util.List;

public interface ProjectDAO {

    void createProject(Project project);

    void updateProject(Project project);

    void deleteProject(Long id);

    Project getProject(Long id);

    List<Project> getAllProjects();
}
