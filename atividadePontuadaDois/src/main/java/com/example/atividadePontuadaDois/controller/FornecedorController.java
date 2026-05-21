package com.example.atividadePontuadaDois.controller;

import com.example.atividadePontuadaDois.dto.FornecedorRequestDTO;
import com.example.atividadePontuadaDois.dto.FornecedorResponseDTO;
import com.example.atividadePontuadaDois.entity.FornecedorEntity;
import com.example.atividadePontuadaDois.service.FornecedorService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    //LISTAR
    @GetMapping
    public ResponseEntity <List<FornecedorResponseDTO>> Listar (){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarFornecedor());
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity <Map<String, Object>> addFornecedor (@Valid @RequestBody FornecedorRequestDTO dto) {
        service.adicionarFornecedor(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Fornecedor cadastrado com sucesso!"));
    }

    //ATUALIZAR POR EMAIL
    @PutMapping ("/{email}")
    public ResponseEntity <Map<String, Object>> atualizarFornecedor (
            @PathVariable String email,
            @RequestBody FornecedorEntity fornecedor) {

        service.atualizarFornecedor(email, fornecedor);
        return ResponseEntity.ok(Map.of("Mensagem", "Fornecedor atualizado com sucesso!"));
    }

    //EXCLUIR POR EMAIL
    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> excluirFornecedor (@PathVariable String email) {
        service.excluirFornecedor(email);
        return ResponseEntity.ok(Map.of("Mensagem", "Fornecedor deletado com sucesso!"));
    }


}
