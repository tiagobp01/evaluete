package br.com.ekan.evaluete.model.web.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
@Data
@Getter
@Setter
@Accessors(chain = true)
public class BeneficiarioUpdateResquest {
    @NotNull
    private String nome;

    @NotNull(message = "Telefone deve ser informado")
    private String telefone;

    @NotNull(message = "Data de nascimento deve ser informada")
    private LocalDate dataNascimento;

}
