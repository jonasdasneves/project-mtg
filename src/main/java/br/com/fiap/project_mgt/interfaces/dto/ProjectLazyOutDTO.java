package br.com.fiap.project_mgt.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

public record ProjectLazyOutDTO(Long id, String name, LocalDate startDate, LocalDate endDate){}
