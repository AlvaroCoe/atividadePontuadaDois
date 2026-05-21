package com.example.atividadePontuadaDois.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {

    @NotBlank (message = "Informe seu nome!")
    private String nome;

    @NotBlank (message = "Informe seu cpf!")
    private String cpf;

    @NotBlank (message = "Informe seu email!")
    @Email (message = "Informe um email válido")
    private String email;

    @NotBlank (message = "Informe seu telefone!")
    @Size (min = 11, max = 18, message = "Informe seu número de telefone com ou seu DDD")
    private String telefone;

    @NotBlank (message = "Informe seu setor!")
    private String setor;

    @NotNull(message = "Informe seu salário!")
    private double salario;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String cpf, String email, String telefone, String setor, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
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

    public @NotBlank(message = "Informe seu setor!") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "Informe seu setor!") String setor) {
        this.setor = setor;
    }

    @NotNull(message = "Informe seu salário!")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "Informe seu salário!") double salario) {
        this.salario = salario;
    }
}
