package com.br.emakers.ToDoListAPI.controller;

import com.br.emakers.ToDoListAPI.data.dto.request.CategoryRequestDTO;
import com.br.emakers.ToDoListAPI.data.dto.response.CategoryResponseDTO;
import com.br.emakers.ToDoListAPI.service.CategoryService;
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
@RequestMapping("/category")
@Tag(name = "Category", description = "Endpoints relacionados às categorias")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Lista as categorias",
            description = "Lista todas as categorias do Banco de Dados.",
            tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value="/all",
    produces = "application/json")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @Operation(summary = "Busca uma categoria por ID",
            description = "Busca uma categoria no Banco de Dados usando o ID como parâmetro.",
            tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/{idCategory}",
            produces = "application/json") // idCategory é a variável sendo passada no Path da requisição
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long idCategory) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(idCategory));
    }

    @Operation(summary = "Cria uma categoria",
            description = "Cria uma nova categoria no Banco de Dados.",
            tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PostMapping(value = "/create",
            produces = "application/json",
            consumes = "application/json")
    // Especifica consumes para indicar que espera dados no corpo da solicitação no formato JSON
    public ResponseEntity<CategoryResponseDTO> createCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryRequestDTO));
    }

    @Operation(summary = "Atualiza uma categoria",
            description = "Atualiza alguma das categorias do Banco de Dados.",
            tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/update/{idCategory}",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long idCategory,
                                                              @Valid @RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(idCategory, categoryRequestDTO));
    }

    @Operation(summary = "Exclui uma categoria",
            description = "Exclui uma das categorias do Banco de Dados.",
            tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @DeleteMapping(value = "/delete/{idCategory}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long idCategory){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteCategory(idCategory));
    }
}