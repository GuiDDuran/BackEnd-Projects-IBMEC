package br.com.ibmec.backend.cadastrocliente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Column
    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Formato incorreto")
    private String email;

    @Column
    @NotBlank(message = "Campo obrigatório")
    private String cpf;

    @Column
    @NotBlank(message = "Campo obrigatório")
    private String dataNascimento;
}
