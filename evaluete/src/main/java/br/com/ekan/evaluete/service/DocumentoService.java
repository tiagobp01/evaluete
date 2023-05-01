package br.com.ekan.evaluete.service;

import br.com.ekan.evaluete.model.Beneficiario;
import br.com.ekan.evaluete.model.Documento;
import br.com.ekan.evaluete.model.web.request.DocumentoRequest;
import br.com.ekan.evaluete.model.web.response.DocumentoResponse;

import java.util.List;

public interface DocumentoService {

    List<DocumentoResponse> fincAllDocumentosById(long id);

    DocumentoResponse updateDocumentoById(long id, long idDocumento, DocumentoResponse documentoResponse);

    long deleteDocumento(long id, long idDocumento);

}
