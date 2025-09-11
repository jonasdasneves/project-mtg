package br.com.fiap.projectmgt.application.service.Impl;

import br.com.fiap.projectmgt.application.service.ProjectService;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.repository.ProjectRepository;
import br.com.fiap.projectmgt.infrastructure.mapper.JpaProjectMapper;
import br.com.fiap.projectmgt.infrastructure.mapper.PageMapper;
import br.com.fiap.projectmgt.infrastructure.repository.JpaProjectEntityRepository;
import br.com.fiap.projectmgt.domain.entity.Page;
import org.springframework.data.domain.Pageable;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    public Page<Project> listAll(int pageNumber, int pageSize){
        return this.repository.listAllProjects(pageNumber, pageSize);
    }

    @Override
    public Project findById(Long projectId) {
        return this.repository.findProjectById(projectId);
    }

    @Override
    public Project create(Project newProject) {
        return null;
    }

    @Override
    public Project update(Project updProject) {
        return null;
    }

    @Override
    public void delete(Long projectId) {

    }
}
