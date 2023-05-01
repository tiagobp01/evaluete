package br.com.ekan.evaluete.service;

import br.com.ekan.evaluete.model.web.response.DocumentoResponse;
import br.com.ekan.evaluete.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImp implements DocumentoService{

    private final ModelMapper modelMapper;

    private final DocumentoRepository documentoRepository;


    @Override
    public List<DocumentoResponse> fincAllDocumentosById(long id) {
        return documentoRepository.findByBeneficiarioId(id).stream().map(documento -> modelMapper.map(documento, DocumentoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public DocumentoResponse updateDocumentoById(long idBeneficiario, long idDocumento, DocumentoResponse documentoResponse) {

        var documento = documentoRepository.findByBenefiarioIdAndId( idDocumento, idBeneficiario);

        if(documento.isEmpty()) {

            throw new RuntimeException("Docimento não encontrado");

        }

        documentoRepository.updateDescricaoAndTipoDocumentoById(documentoResponse.getDescricao(), documentoResponse.getTipoDocumento(), idDocumento);

        return documentoRepository.findByBenefiarioIdAndId( idDocumento, idBeneficiario)
                .map(documento1 -> modelMapper.map(documento, DocumentoResponse.class) )
                .orElse(null);
    }

    @Override
    public long deleteDocumento(long idBeneficiario, long idDocumento) {
        var documento = documentoRepository.findByBenefiarioIdAndId( idDocumento, idBeneficiario);

        if(documento.isEmpty()) {

            throw new RuntimeException("Docimento não encontrado");

        }

        return documentoRepository.deleteByIdAllIgnoreCase(idDocumento);

    }
}
