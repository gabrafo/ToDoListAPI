package com.br.emakers.ToDoListAPI.controller;

import com.br.emakers.ToDoListAPI.data.dto.request.TaskRequestDTO;
import com.br.emakers.ToDoListAPI.data.dto.response.CategoryResponseDTO;
import com.br.emakers.ToDoListAPI.data.dto.response.TaskResponseDTO;
import com.br.emakers.ToDoListAPI.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Tag(name = "Task", description = "Endpoints relacionados às tarefas")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Lista todas as tarefas",
            description = "Lista todas as tarefas do Banco de Dados.",
            tags = {"Task"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation =TaskResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @Operation(summary = "Busca uma tarefa por ID",
            description = "Busca uma tarefa com base no ID fornecido.",
            tags = {"Task"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation =TaskResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "{idTask}", produces = "application/json")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long idTask) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(idTask));
    }

    @Operation(summary = "Cria uma tarefa",
            description = "Cria uma nova tarefa no Banco de Dados (requer uma categoria já existente).",
            tags = {"Task"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation =TaskResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskRequestDTO));
    }

    @Operation(summary = "Atualiza uma tarefa",
            description = "Atualiza uma tarefa com base no ID fornecido.",
            tags = {"Task"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation =TaskResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/update/{idTask}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TaskResponseDTO> updateTask(@Valid @PathVariable Long idTask, @RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTaskById(idTask, taskRequestDTO));
    }

    @Operation(summary = "Exclui uma tarefa",
            description = "Exclui uma tarefa com base no ID fornecido.",
            tags = {"Task"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation =TaskResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @DeleteMapping(value = "/delete/{idTask}")
    public ResponseEntity<String> deleteTask(@PathVariable Long idTask) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteTask(idTask));
    }
}