package com.example.atividadePontuadaDois.controller;

import com.example.atividadePontuadaDois.dto.ClienteRequestDTO;
import com.example.atividadePontuadaDois.dto.ClienteResponseDTO;
import com.example.atividadePontuadaDois.entity.ClienteEntity;
import com.example.atividadePontuadaDois.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    //LISTAR
    @GetMapping
    public ResponseEntity <List<ClienteResponseDTO>> Listar (){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarCliente());
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity <Map<String, Object>> addCliente (@Valid @RequestBody ClienteRequestDTO dto) {
        service.adicionarCliente(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente cadastrado com sucesso!"));
    }

    //ATUALIZAR POR EMAIL
    @PutMapping ("/{email}")
    public ResponseEntity <Map<String, Object>> atualizarCliente (
            @PathVariable String email,
            @RequestBody ClienteEntity cliente) {

        service.atualizarCliente(email, cliente);
        return ResponseEntity.ok(Map.of("Mensagem", "Cliente atualizado com sucesso!"));
    }

    //EXCLUIR POR EMAIL
    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> excluirCliente (@PathVariable String email) {
        service.excluirCliente(email);
        return ResponseEntity.ok(Map.of("Mensagem", "Cliente deletado com sucesso!"));
    }


}
