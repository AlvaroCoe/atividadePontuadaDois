package com.example.atividadePontuadaDois.controller;

import com.example.atividadePontuadaDois.dto.FuncionarioRequestDTO;
import com.example.atividadePontuadaDois.dto.FuncionarioResponseDTO;
import com.example.atividadePontuadaDois.entity.FuncionarioEntity;
import com.example.atividadePontuadaDois.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    //LISTAR
    @GetMapping
    public ResponseEntity <List<FuncionarioResponseDTO>> Listar (){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarFuncionario());
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity <Map<String, Object>> AddFuncionario (@Valid @RequestBody FuncionarioRequestDTO dto) {
        service.adicionarFuncionario(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Funcionario cadastrado com sucesso!"));
    }

    //ATUALIZAR POR EMAIL
    @PutMapping ("/{email}")
    public ResponseEntity <Map<String, Object>> AtualizarFuncionario (
            @PathVariable String email,
            @RequestBody FuncionarioEntity funcionario) {

        service.atualizarFuncionario(email, funcionario);
        return ResponseEntity.ok(Map.of("Mensagem", "Funcionário atualizado com sucesso!"));
    }

    //EXCLUIR POR EMAIL
    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> ExcluirFuncionario (@PathVariable String email) {
        service.excluirFuncionario(email);
        return ResponseEntity.ok(Map.of("Mensagem", "Funcionário deletado com sucesso!"));
    }


}
