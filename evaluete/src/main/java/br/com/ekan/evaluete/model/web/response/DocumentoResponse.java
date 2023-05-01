package br.com.ekan.evaluete.model.web.response;

import br.com.ekan.evaluete.communs.TipoDocumento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class DocumentoResponse extends EntityResponse{

    private TipoDocumento tipoDocumento;

    private String descricao;

}
