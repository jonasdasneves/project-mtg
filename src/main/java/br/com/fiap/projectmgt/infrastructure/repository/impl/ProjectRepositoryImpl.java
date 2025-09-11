package br.com.fiap.projectmgt.infrastructure.repository.impl;

import br.com.fiap.projectmgt.domain.entity.Page;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.repository.ProjectRepository;
import br.com.fiap.projectmgt.infrastructure.mapper.JpaProjectMapper;
import br.com.fiap.projectmgt.infrastructure.mapper.PageMapper;
import br.com.fiap.projectmgt.infrastructure.repository.JpaProjectEntityRepository;
import org.springframework.data.domain.Pageable;

public class ProjectRepositoryImpl implements ProjectRepository {

    private final JpaProjectEntityRepository repository;

    public ProjectRepositoryImpl(JpaProjectEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Project> listAllProjects(int pageNumber, int pageSize) {
        return PageMapper.fromFrameworkPage(
                this.repository.findAll(
                        Pageable
                                .ofSize(pageSize)
                                .withPage(pageNumber)
                ).map(JpaProjectMapper::toEntity));
    }

    @Override
    public Project findProjectById(Long projectId) {
        return JpaProjectMapper.toEntity(
                this.repository
                        .findById(projectId)
                        .orElseThrow()
        );
    }

    @Override
    public Project createProject(Project newProject) {
        return null;
    }

    @Override
    public Project updateProject(Project updProject) {
        return null;
    }

    @Override
    public void deleteProject(Long projectId) {

    }
}
