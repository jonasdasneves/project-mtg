package br.com.fiap.project_mgt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProjectController {

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> helloWorld() {
        return ResponseEntity.ok(Map.of("message", "Hello"));
    }
}
