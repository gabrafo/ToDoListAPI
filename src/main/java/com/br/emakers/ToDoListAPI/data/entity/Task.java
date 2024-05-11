package com.br.emakers.ToDoListAPI.data.entity;

import com.br.emakers.ToDoListAPI.data.dto.request.TaskRequestDTO;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotações do Lombok pra gerar getters/setters
@Getter
@Setter
@NoArgsConstructor

@Entity // Define que é uma entidade
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor gerado automatiamente de maneira incremental
    private Long idTask;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "situation", nullable = false, length = 20)
    private String situation;

    @ManyToOne // Define a relação muitos pra um de Task e Category
    @JoinColumn(name = "idCategory") // Coluna de junção
    private Category category;

    // Construtor usando Record pra facilitar
    @Builder
    public Task(TaskRequestDTO taskRequestDTO){
        this.name = taskRequestDTO.name();
        this.situation = taskRequestDTO.situation();
        this.category = taskRequestDTO.category();
    }
}
