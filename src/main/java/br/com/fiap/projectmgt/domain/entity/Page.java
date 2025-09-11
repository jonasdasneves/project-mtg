package br.com.fiap.projectmgt.domain.entity;

import java.util.List;

public record Page<T>(int numberOfPages,
                      int pageNumber,
                      List<T> pageItems)
{ }
