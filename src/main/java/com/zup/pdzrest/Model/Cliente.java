package com.zup.pdzrest.Model;


import com.zup.pdzrest.functions.Functions;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_cliente;

    @NotBlank(message = "Nome não deve estar em branco.")
    private String nome;

    @DecimalMin(value = "1")
    @NotNull(message = "Salario não deve estar em branco.")
    private BigDecimal salario;

    @Email(message = "Email não esta no formato correto.")
    @NotBlank(message = "Email não deve estar em branco.")
    private String email;

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento() {

        this.segmento = String.valueOf(Functions.defineSegmento(getSalario().doubleValue()));
    }

    private String segmento;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
}
