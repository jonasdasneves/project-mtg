package br.com.fiap.projectmgt.domain.repository;

import br.com.fiap.projectmgt.domain.entity.Page;
import br.com.fiap.projectmgt.domain.entity.Project;

public interface ProjectRepository {

    public Page<Project> listAllProjects(int pageNumber, int pageSize);

    public Project findProjectById(Long projectId);

    public Project createProject(Project newProject);

    public Project updateProject(Project updProject);

    public void deleteProject(Long projectId);
}
