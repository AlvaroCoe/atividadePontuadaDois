package com.example.atividadePontuadaDois.service;

import com.example.atividadePontuadaDois.dto.FornecedorRequestDTO;
import com.example.atividadePontuadaDois.dto.FornecedorResponseDTO;
import com.example.atividadePontuadaDois.entity.FornecedorEntity;
import com.example.atividadePontuadaDois.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    // LISTAR
    public List <FornecedorResponseDTO> listarFornecedor () {
        return repository
                .findAll()
                .stream()
                .map(f -> new FornecedorResponseDTO(
                        f.getNome(),
                        f.getTelefone()

                ))
                .toList();
    }

    // ADICIONAR

    public FornecedorEntity adicionarFornecedor (FornecedorRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email já em uso!");
        }

        FornecedorEntity novoFornecedor = new FornecedorEntity();
        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setCnpj(dto.getCnpj());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());

        return repository.save(novoFornecedor);

    }

    // ATUALIZAR POR EMAIL

    public FornecedorEntity atualizarFornecedor (String email, FornecedorEntity novosDados) {
        FornecedorEntity fornecedorExistente = repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Forncedor com email  " + email + "  não encontrado"));

        // Mantém o ID original para atualizar o mesmo registro

        novosDados.setId(fornecedorExistente.getId());
        return repository.save(novosDados);
    }

    // DELETAR POR EMAIL

    public void excluirFornecedor (String email) {
        if (repository.findByEmail(email).isEmpty()) {
            throw new IllegalArgumentException("Fornecedor não encontrado com o email: " + email);
        }
        repository.deleteByEmail(email  );
    }

}
