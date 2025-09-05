package br.com.fiap.projectmgt.infrastructure.mapper;

import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;

public class JpaProjectMapper {

    public static Project toEntity(JpaProjectEntity jpaProjectEntity) {
        return new Project(
                jpaProjectEntity.getId(),
                jpaProjectEntity.getName(),
                jpaProjectEntity.getDescription(),
                jpaProjectEntity.getStartDate(),
                jpaProjectEntity.getEndDate());
    }

    public static JpaProjectEntity toJpaEntity(Project project) {
        return new JpaProjectEntity(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate());
    }

    private JpaProjectMapper() {
    }
}
