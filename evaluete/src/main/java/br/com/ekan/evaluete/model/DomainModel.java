package br.com.ekan.evaluete.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class DomainModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataInclusao;

    @NotNull
    private LocalDateTime dataAtualizacao;

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    @PrePersist
    public void perPersist() {
        var now = LocalDateTime.now();
        this.dataInclusao = now;
        this.dataAtualizacao = now;
    }

    public Long getId() {
        return id;
    }

    public DomainModel setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public DomainModel setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
        return this;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public DomainModel setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
        return this;
    }
}
