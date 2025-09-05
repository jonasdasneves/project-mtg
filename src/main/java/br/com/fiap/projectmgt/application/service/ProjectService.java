package br.com.fiap.projectmgt.application.service;

import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;
import br.com.fiap.projectmgt.interfaces.page.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface ProjectService {

    public Page<Project> listAll(int pageNumber, int pageSize);

    public Project findById(Long projectId);

    public Project create(Project newProject);

    public Project update(Project updProject);

    public void delete(Long projectId);
}
