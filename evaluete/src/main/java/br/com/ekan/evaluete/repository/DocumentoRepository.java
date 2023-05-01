package br.com.ekan.evaluete.repository;

import br.com.ekan.evaluete.communs.TipoDocumento;
import br.com.ekan.evaluete.model.Documento;
import br.com.ekan.evaluete.model.web.response.DocumentoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    @Transactional
    @Modifying
    @Query("update Documento d set d.descricao = ?1, d.tipoDocumento = ?2 where d.id = ?3")
    int updateDescricaoAndTipoDocumentoById(@Nullable String descricao, @Nullable TipoDocumento tipoDocumento, Long id);
    @Transactional
    @Modifying
    @Query("update Documento d set d.tipoDocumento = ?1, d.descricao = ?2 where d.id = ?3")
    int updateTipoDocumentoAndDescricaoById(@Nullable TipoDocumento tipoDocumento, String descricao, @NonNull Long id);

    @Transactional
    long deleteByIdAllIgnoreCase(@NonNull Long id);
    List<Documento> findByBeneficiarioId(Long id);

    @Query("select d from Documento d where d.id = ?1 and d.beneficiario.id = ?2")
    Optional<Documento> findByBenefiarioIdAndId(Long id, Long idBeneficiario);



}
