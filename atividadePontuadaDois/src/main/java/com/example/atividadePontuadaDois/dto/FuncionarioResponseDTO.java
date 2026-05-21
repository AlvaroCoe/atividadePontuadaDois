package com.example.atividadePontuadaDois.dto;

public class FuncionarioResponseDTO {

    private String nome;
    private String email;
    private String telefone;
    private String setor;

    public FuncionarioResponseDTO() {
    }

    public FuncionarioResponseDTO(String nome, String email, String telefone, String setor) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
