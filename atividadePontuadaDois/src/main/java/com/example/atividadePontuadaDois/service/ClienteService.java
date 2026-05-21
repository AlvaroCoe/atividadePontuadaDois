package com.example.atividadePontuadaDois.service;

import com.example.atividadePontuadaDois.dto.ClienteRequestDTO;
import com.example.atividadePontuadaDois.dto.ClienteResponseDTO;

import com.example.atividadePontuadaDois.entity.ClienteEntity;
import com.example.atividadePontuadaDois.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // LISTAR
    public List <ClienteResponseDTO> listarCliente () {
        return repository
                .findAll()
                .stream()
                .map(f -> new ClienteResponseDTO(
                        f.getNome(),
                        f.getEmail()

                ))
                .toList();
    }

    // ADICIONAR

    public ClienteEntity adicionarCliente (ClienteRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("EMail já em uso!");
        }

        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setNome(dto.getNome());
        novoCliente.setCpf(dto.getCpf());
        novoCliente.setDataNascimento(dto.getDataNascimento());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setSenha(passwordEncoder.encode(dto.getSenha()));

        return repository.save(novoCliente);

    }

    // ATUALIZAR POR EMAIL

    public ClienteEntity atualizarCliente (String email, ClienteEntity novosDados) {
        ClienteEntity clienteExistente = repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com email  " + email + "  não encontrado"));

        // Mantém o ID original para atualizar o mesmo registro

        novosDados.setId(clienteExistente.getId());
        return repository.save(novosDados);
    }

    // DELETAR POR EMAIL

    public void excluirCliente (String email) {
        if (repository.findByEmail(email).isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com o email: " + email);
        }
        repository.deleteByEmail(email);
    }

}
