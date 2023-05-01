package br.com.ekan.evaluete.service;

import br.com.ekan.evaluete.model.Beneficiario;
import br.com.ekan.evaluete.model.Documento;
import br.com.ekan.evaluete.model.web.request.BeneficiarioRequest;
import br.com.ekan.evaluete.model.web.request.BeneficiarioUpdateResquest;
import br.com.ekan.evaluete.model.web.request.DocumentoRequest;
import br.com.ekan.evaluete.model.web.response.BeneficiarioResponse;
import br.com.ekan.evaluete.model.web.response.DocumentoResponse;
import br.com.ekan.evaluete.repository.BeneficiarioRepository;
import br.com.ekan.evaluete.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficiarioServiceImp implements BeneficiarioService{

    private final BeneficiarioRepository beneficiarioRepository;

    private final DocumentoRepository documentoRepository;

    private final ModelMapper modelMapper;

    @Override
    public Beneficiario save(BeneficiarioRequest beneficiarioRequest) {

        try {
            var beneficiario = modelMapper.map(beneficiarioRequest, Beneficiario.class);

            List<Documento> lstDocumentos = getDocumentos(beneficiarioRequest.getDocumentos());

            lstDocumentos.forEach(documento -> documento.setBeneficiario(beneficiario));

            beneficiario.setDocumentos(lstDocumentos);

            beneficiarioRepository.save( beneficiario);

            documentoRepository.saveAll(lstDocumentos);

            return beneficiario;

        }catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    private List<Documento> getDocumentos(List<DocumentoRequest> documentos) {

        return documentos.stream().map(documentoRequest -> modelMapper.map(documentoRequest, Documento.class))
                .collect(Collectors.toList());

    }

    @Override
    public BeneficiarioResponse findById(Long id) {

        return beneficiarioRepository.findById(id).map(beneficiario -> modelMapper.map(beneficiario, BeneficiarioResponse.class))
                        .orElse(null);

    }

    @Override
    public List<BeneficiarioResponse> findAll() {

        return beneficiarioRepository.findAll().stream().map(beneficiario -> modelMapper.map(beneficiario, BeneficiarioResponse.class))
                .collect(Collectors.toList())
                ;
    }

    @Override
    public Beneficiario updateBeneficiario(Long id, BeneficiarioUpdateResquest beneficiarioRequest) {

        var beneficiario = beneficiarioRepository.findById(id);

        if(beneficiario.isEmpty()) {

            throw new RuntimeException("Usuário não encontrado");
        }
         beneficiarioRepository.updateById(beneficiarioRequest.getNome(), beneficiarioRequest.getTelefone(), beneficiarioRequest.getDataNascimento(), id);

        return beneficiarioRepository.findById(id).orElse(null);

    }

    @Override
    public long removeBeneficiarioById(Long id) {

        return beneficiarioRepository.deleteByIdAllIgnoreCase(id);

    }

}
