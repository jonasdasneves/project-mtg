package br.com.fiap.project_mgt.controller;

import br.com.fiap.project_mgt.domain.entity.Project;
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
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projects);
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
