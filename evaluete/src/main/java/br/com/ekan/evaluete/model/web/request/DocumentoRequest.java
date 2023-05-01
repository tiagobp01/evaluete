package br.com.ekan.evaluete.model.web.request;

import br.com.ekan.evaluete.communs.TipoDocumento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoRequest {

    @NotNull
    private TipoDocumento tipoDocumento;

    @NotNull
    private String descricao;

}
