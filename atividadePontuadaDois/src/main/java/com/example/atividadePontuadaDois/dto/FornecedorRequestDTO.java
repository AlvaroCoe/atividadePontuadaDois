package com.example.atividadePontuadaDois.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FornecedorRequestDTO {

    @NotBlank(message = "Informe seu nome!")
    private String nome;

    @NotBlank(message = "Informe o CNPJ de sua empresa!")
    private String cnpj;

    @NotBlank(message = "Informe seu email!")
    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "Informe seu telefone!")
    @Size(min = 11, max = 18, message = "Informe seu número de telefone com ou seu DDD")
    private String telefone;

    public FornecedorRequestDTO() {
    }

    public FornecedorRequestDTO(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "Informe seu nome!") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Informe seu nome!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Informe seu cpf!") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank(message = "Informe seu cpf!") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank(message = "Informe seu email!") @Email(message = "Informe um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Informe seu email!") @Email(message = "Informe um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Informe seu telefone!") @Size(min = 11, max = 18, message = "Informe seu número de telefone com ou seu DDD") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Informe seu telefone!") @Size(min = 11, max = 18, message = "Informe seu número de telefone com ou seu DDD") String telefone) {
        this.telefone = telefone;
    }
}