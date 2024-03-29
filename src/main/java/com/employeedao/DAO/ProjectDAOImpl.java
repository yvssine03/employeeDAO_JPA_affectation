package com.employeedao.DAO;



import com.employeedao.Model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

    public class ProjectDAOImpl implements ProjectDAO {

        private EntityManagerFactory emf = Persistence.createEntityManagerFactory("re");
        private EntityManager em;

        public ProjectDAOImpl() {
            em = emf.createEntityManager();
        }

        @Override
        public void addProject(Project project) {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        }

        @Override
        public void createProject(Project project) {

        }

        @Override
        public void updateProject(Project project) {
            em.getTransaction().begin();
            em.merge(project);
            em.getTransaction().commit();
        }

        @Override
        public void deleteProject(Long id) {
            Project project = em.find(Project.class, id);
            if (project != null) {
                em.getTransaction().begin();
                em.remove(project);
                em.getTransaction().commit();
            }
        }

        @Override
        public Project getProject(Long id) {
            return em.find(Project.class, id);
        }

        @Override
        public List<Project> getAllProjects() {
            Query query = em.createQuery("SELECT p FROM Project p");
            return query.getResultList();
        }
    }

}
