package br.com.ekan.evaluete.repository;

import br.com.ekan.evaluete.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    @Transactional
    long deleteByIdAllIgnoreCase(@NonNull Long id);
    @Transactional
    @Modifying
    @Query("update Beneficiario b set b.nome = ?1, b.telefone = ?2, b.dataNascimento = ?3 where b.id = ?4")
    int updateById(@NonNull String nome, @NonNull String telefone, @NonNull LocalDate dataNascimento, @NonNull Long id);
}
