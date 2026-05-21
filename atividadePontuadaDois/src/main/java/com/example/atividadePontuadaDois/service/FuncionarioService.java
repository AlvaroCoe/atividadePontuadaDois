package com.example.atividadePontuadaDois.service;

import com.example.atividadePontuadaDois.dto.FuncionarioRequestDTO;
import com.example.atividadePontuadaDois.dto.FuncionarioResponseDTO;
import com.example.atividadePontuadaDois.entity.FuncionarioEntity;
import com.example.atividadePontuadaDois.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // LISTAR
    public List <FuncionarioResponseDTO> listarFuncionario () {
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone(),
                        f.getSetor()

                ))
                .toList();
    }

    // ADICIONAR

    public FuncionarioEntity adicionarFuncionario (FuncionarioRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("EMail já em uso!");
        }

        FuncionarioEntity novoFuncionario = new FuncionarioEntity();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setCpf(dto.getCpf());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());
        novoFuncionario.setSetor(dto.getSetor());
        novoFuncionario.setSalario(dto.getSalario());

        return repository.save(novoFuncionario);

    }

    // ATUALIZAR POR EMAIL

    public FuncionarioEntity atualizarFuncionario (String email, FuncionarioEntity novosDados) {
        FuncionarioEntity FuncionarioExistente = repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário com email  " + email + "  não encontrado"));

        // Mantém o ID original para atualizar o mesmo registro

        novosDados.setId(FuncionarioExistente.getId());
        return repository.save(novosDados);
    }

    // DELETAR POR EMAIL

    public void excluirFuncionario (String email) {
        if (repository.findByEmail(email).isEmpty()) {
            throw new IllegalArgumentException("Funcionário não encontrado com o email: " + email);
        }
        repository.deleteByEmail(email  );
    }

}
