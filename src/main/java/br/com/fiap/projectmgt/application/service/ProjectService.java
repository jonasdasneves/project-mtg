package br.com.fiap.projectmgt.application.service;

import br.com.fiap.projectmgt.domain.entity.Page;
import br.com.fiap.projectmgt.domain.entity.Project;

import java.util.List;

public interface ProjectService {

    Page<Project> listAll(int pageNumber, int pageSize);

    Project findById(Long projectId);

    Project create(Project newProject);

    Project update(Project updProject);

    void delete(Long projectId);
}
