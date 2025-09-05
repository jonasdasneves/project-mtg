package br.com.fiap.projectmgt.infrastructure.mapper;

import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.interfaces.dto.ProjectInDto;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDto;

public final class DtoProjectMapper {

    public static Project fromDto(ProjectInDto projectInDto){
        return new Project(
                projectInDto.name(),
                projectInDto.description(),
                projectInDto.startDate(),
                projectInDto.endDate());
    }

    public static ProjectOutDto toDto(Project project){
        return new ProjectOutDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate());
    }

    private DtoProjectMapper() {
    }
}
