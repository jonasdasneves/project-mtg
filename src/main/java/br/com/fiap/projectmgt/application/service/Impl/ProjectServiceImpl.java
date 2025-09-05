package br.com.fiap.projectmgt.application.service.Impl;

import br.com.fiap.projectmgt.application.service.ProjectService;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;
import br.com.fiap.projectmgt.infrastructure.mapper.JpaProjectMapper;
import br.com.fiap.projectmgt.infrastructure.repository.JpaProjectEntityRepository;
import br.com.fiap.projectmgt.interfaces.page.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class ProjectServiceImpl implements ProjectService {

    private final JpaProjectEntityRepository repository;

    public ProjectServiceImpl(JpaProjectEntityRepository jpaProjectEntityRepository, JpaProjectEntityRepository repository) {
        this.repository = repository;
    }

    public Page<Project> listAll(int pageNumber, int pageSize){
        //Não é uma boa pratica usar o repository diretamente na camada
        // controller nem a classe utilizada no mapeamento do banco. Apenas para exemplo!!
        Page<Project> pageOfProjects = (Page<Project>) this.repository.findAll(
                Pageable
                        .ofSize(pageSize)
                        .withPage(pageNumber)
        ).map(JpaProjectMapper::toEntity);

        return pageOfProjects;
    }


    @Override
    public Project findById(Long projectId) {
        return null;
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
