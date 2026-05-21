package com.example.atividadePontuadaDois.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {

    @NotBlank (message = "Informe seu nome!")
    private String nome;

    @NotBlank (message = "Informe seu cpf!")
    private String cpf;

    private String dataNascimento;

    @NotBlank (message = "Informe seu email!")
    @Email (message = "Informe um email válido")
    private String email;

    @NotBlank (message = "Adicione uma senha!")
    @Size (min = 8, max = 60, message = "Cadastre uma senha entre 8 a 60 caracteres.")
    private String senha;


    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cpf, String dataNascimento, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "Informe seu nome!") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Informe seu nome!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Informe seu cpf!") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "Informe seu cpf!") String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "Informe seu email!") @Email(message = "Informe um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Informe seu email!") @Email(message = "Informe um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Adicione uma senha!") @Size(min = 8, max = 60, message = "Cadastre uma senha entre 8 a 60 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Adicione uma senha!") @Size(min = 8, max = 60, message = "Cadastre uma senha entre 8 a 60 caracteres.") String senha) {
        this.senha = senha;
    }
}

