package br.com.ekan.evaluete.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Beneficiario extends DomainModel{

    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.REMOVE)
    private List<Documento> documentos;


}
