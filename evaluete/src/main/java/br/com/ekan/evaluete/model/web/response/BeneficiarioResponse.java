package br.com.ekan.evaluete.model.web.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BeneficiarioResponse extends  EntityResponse{

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private List<DocumentoResponse> documentos;


}
