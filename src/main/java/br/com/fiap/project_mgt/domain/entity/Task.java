package br.com.fiap.project_mgt.domain.entity;

import java.time.LocalDate;

public class Task {
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String owner;
}
