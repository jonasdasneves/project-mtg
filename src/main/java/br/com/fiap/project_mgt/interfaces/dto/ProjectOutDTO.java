package br.com.fiap.project_mgt.interfaces.dto;

import java.time.LocalDate;


public record ProjectOutDTO(Long id,
                            String name,
                            String description,
                            LocalDate startDate,
                            LocalDate endDate
) {}
