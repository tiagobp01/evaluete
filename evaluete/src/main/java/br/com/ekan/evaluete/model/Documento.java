package br.com.ekan.evaluete.model;

import br.com.ekan.evaluete.communs.TipoDocumento;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Documento extends DomainModel{

    @NotNull
    private TipoDocumento tipoDocumento;

    @NotNull
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

}
