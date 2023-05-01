package br.com.ekan.evaluete.controller;

import br.com.ekan.evaluete.model.web.request.BeneficiarioRequest;
import br.com.ekan.evaluete.model.web.request.BeneficiarioUpdateResquest;
import br.com.ekan.evaluete.model.web.response.BeneficiarioResponse;
import br.com.ekan.evaluete.model.web.response.DocumentoResponse;
import br.com.ekan.evaluete.service.BeneficiarioService;
import br.com.ekan.evaluete.service.DocumentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    private final DocumentoService documentoService;

    private final ModelMapper modelMapper;

    @PostMapping
    public BeneficiarioResponse create(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest) {
        return modelMapper.map(beneficiarioService.save(beneficiarioRequest), BeneficiarioResponse.class);
    }

    @GetMapping("{id}")
    public BeneficiarioResponse listBeneficiarioById(@PathVariable long id) {
        return beneficiarioService.findById(id);
    }

    @GetMapping("/all")
    public List<BeneficiarioResponse> listAll() {

        return beneficiarioService.findAll();
    }

    @PutMapping("{id}")
    public BeneficiarioResponse updateBeneficiario(@PathVariable long id, @RequestBody @Valid BeneficiarioUpdateResquest beneficiarioRequest) {
        return modelMapper.map(beneficiarioService.updateBeneficiario(id, beneficiarioRequest), BeneficiarioResponse.class);
    }

    @DeleteMapping("{id}")
    public Long delete(@PathVariable long id) {
        return beneficiarioService.removeBeneficiarioById(id);
    }

    @GetMapping("/{id}/documentos")
    public List<DocumentoResponse> getDocumentosById(@PathVariable long id) {
        return documentoService.fincAllDocumentosById(id);
    }

    @PutMapping("/{id}/documentos/{idDocumento}")
    public DocumentoResponse updateDocumentosById(@PathVariable long id, @PathVariable long idDocumento, @RequestBody @Valid DocumentoResponse documentoResponse) {
        return documentoService.updateDocumentoById(id, idDocumento, documentoResponse);
    }

    @DeleteMapping("/{id}/documentos/{idDocumento}")
    public Long deleteDocumentosById(@PathVariable long id, @PathVariable long idDocumento) {
        return documentoService.deleteDocumento(id, idDocumento);
    }


}
