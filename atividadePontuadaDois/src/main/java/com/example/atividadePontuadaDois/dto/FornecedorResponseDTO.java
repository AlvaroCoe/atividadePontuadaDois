package com.example.atividadePontuadaDois.dto;

public class FornecedorResponseDTO {

    private String nome;
    private String telefone;

    public FornecedorResponseDTO() {
    }

    public FornecedorResponseDTO(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
