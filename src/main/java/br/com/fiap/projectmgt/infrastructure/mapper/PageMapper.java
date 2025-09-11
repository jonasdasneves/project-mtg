package br.com.fiap.projectmgt.infrastructure.mapper;

import br.com.fiap.projectmgt.domain.entity.Page;

public class PageMapper {

    public static <T> Page<T> fromFrameworkPage(org.springframework.data.domain.Page<T> frameworkPage){
        return new Page(
                frameworkPage.getTotalPages(),
                frameworkPage.getNumber(),
                frameworkPage.stream().toList());
    }

    private PageMapper(){}
}
