package br.com.fiap.projectmgt.interfaces.dto;

import java.time.LocalDate;

public record ProjectInDto(String name, String description, LocalDate startDate, LocalDate endDate) {
}
