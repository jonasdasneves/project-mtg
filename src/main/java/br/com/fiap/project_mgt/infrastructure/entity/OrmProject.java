package br.com.fiap.project_mgt.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "project")
public class OrmProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;
}
