package br.com.fiap.projectmgt.interfaces.controller;

import br.com.fiap.projectmgt.application.service.ProjectService;
import br.com.fiap.projectmgt.domain.entity.Page;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.exceptions.ResourceNotFoundException;
import br.com.fiap.projectmgt.infrastructure.mapper.DtoProjectMapper;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

// Não é uma boa pratica expor a entidade na camada controller. Refletir no porque e pensar em uma solução.
@RestController
@RequestMapping("/project")
public class ProjectController {

    //Não é um boa pratica injetar repositories na camada controller. Apenas para exemplo!!
//    @Autowired uma maneira de fazer injecao de dependencia. Sempre dar preferencia para o construtor.
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Page<ProjectOutDto>> getProjects(@RequestParam(name = "pageSize", required = false,defaultValue = "10") Integer pageSize,
                                                               @RequestParam(name = "pageNumber", required = false,defaultValue = "0") Integer pageNumber) {

        Page<Project> projectsPage = this.projectService.listAll(pageNumber, pageSize);

        List<ProjectOutDto> projectsDto = projectsPage
                .pageItems()
                .stream()
                .parallel()
                .map(DtoProjectMapper::toDto)
                .toList();

        Page<ProjectOutDto> projectsDtoPage = new Page<>(
                projectsPage.numberOfPages(),
                projectsPage.pageNumber(),
                projectsDto);

        return ResponseEntity.ok(projectsDtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutDto> getProject(@PathVariable("id") Long id) {
        try {
            final Project project = this.projectService.findById(id);
            final ProjectOutDto projectOutDto = DtoProjectMapper.toDto(project);

            return ResponseEntity.ok(projectOutDto);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Não foi possível localizar o id = "+id);
        }
    }

    @PostMapping
    //Depois fazer o dto In
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = this.projectService.create(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        //Implementar em casa o update
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable("id") Long id) throws Exception {
        throw new Exception();
    }

    @PatchMapping
    public ResponseEntity<Project> patchProject(@RequestBody Project project) {
        //Implementar em casa o patch

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(project);
    }


}
