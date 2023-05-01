package br.com.ekan.evaluete.service;

import br.com.ekan.evaluete.model.Beneficiario;
import br.com.ekan.evaluete.model.web.request.BeneficiarioRequest;
import br.com.ekan.evaluete.model.web.request.BeneficiarioUpdateResquest;
import br.com.ekan.evaluete.model.web.response.BeneficiarioResponse;
import br.com.ekan.evaluete.model.web.response.DocumentoResponse;

import java.util.List;

public interface BeneficiarioService {

    Beneficiario save(BeneficiarioRequest beneficiarioRequest);

    BeneficiarioResponse findById(Long id);

    List<BeneficiarioResponse> findAll();

    Beneficiario updateBeneficiario(Long id, BeneficiarioUpdateResquest beneficiarioRequest);

    long removeBeneficiarioById(Long id);

}
