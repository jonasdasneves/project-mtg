package br.com.fiap.project_mgt.interfaces.controller;

import br.com.fiap.project_mgt.domain.entity.Project;
import br.com.fiap.project_mgt.interfaces.dto.ProjectOutDTO;
import br.com.fiap.project_mgt.interfaces.dto.ProjectLazyOutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final List<Project> projects = new ArrayList<Project>();

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> helloWorld(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message","Eu serei o rei dos piratas"));
    }

    @GetMapping
    public ResponseEntity<List<ProjectLazyOutDTO>> getProjects() {

        List<ProjectLazyOutDTO> dados = projects.stream()
                .map(
                        p -> new ProjectLazyOutDTO(
                                p.getId(),
                                p.getName(),
                                p.getStartDate(),
                                p.getEndDate())
                ).toList();

        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutDTO> getProject(@PathVariable("id") Long id) {

        try {
            final ProjectOutDTO projectOutDTO = projects.stream()
                    .filter(p -> p.getId().equals(id))
                    .map(
                            p -> new ProjectOutDTO(
                                    p.getId(),
                                    p.getName(),
                                    p.getDescription(),
                                    p.getStartDate(),
                                    p.getEndDate())
                    )
                    .findFirst()
                    .orElseThrow();

            return ResponseEntity.ok(projectOutDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        projects.add(project);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(project);
    }

    @PutMapping
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        try {
            Project projectToEdit = this.projects.stream()
                    .filter( p -> p.getId().equals(project.getId()))
                    .findFirst()
                    .orElseThrow();
            projectToEdit.setName(project.getName());
            projectToEdit.setDescription(project.getDescription());

            return ResponseEntity.accepted().body(project);
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        try {
            Project projectToRemove = this.projects.stream()
                    .filter( p -> p.getId().equals(id))
                    .findFirst()
                    .orElseThrow();

            projects.remove(projectToRemove);
            return ResponseEntity.noContent().build();
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
