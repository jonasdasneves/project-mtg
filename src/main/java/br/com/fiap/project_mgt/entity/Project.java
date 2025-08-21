package br.com.fiap.project_mgt.entity;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
public class Project {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

}
