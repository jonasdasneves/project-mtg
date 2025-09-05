package br.com.fiap.projectmgt.domain.entity;

import br.com.fiap.projectmgt.domain.exceptions.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.BadRequestException;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode

// Podemos usar Getter e Setter no nível de classe
//@Setter
//@Getter

//@Data
@Getter
@Setter
public class Project {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<Tarefa> tarefas;

    public Project(String name, String description, LocalDate startDate, LocalDate endDate) {
        if(name.length() >= 5 && name.length() <= 32){
            this.name = name;
        }
        else{
            throw new RegraDeNegocioException("O nome deve ter entre 5 e 32 caracteres");
        }

        if(!description.isEmpty()){
            if (description.length() <= 255){
                this.description = description;
            }
            else{
                throw new RegraDeNegocioException("A descrição deve ter menos de 256 carcteres");
            }
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(Long id, String name, String description, LocalDate startDate, LocalDate endDate) {
        if(name.length() >= 5 && name.length() <= 32){
            this.name = name;
        }
        else{
            throw new RegraDeNegocioException("O nome deve ter entre 5 e 32 caracteres");
        }

        if(!description.isEmpty()){
            if (description.length() <= 255){
                this.description = description;
            }
            else{
                throw new RegraDeNegocioException("A descrição deve ter menos de 256 carcteres");
            }
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }
}
