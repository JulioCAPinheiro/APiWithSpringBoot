package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.Endereco;

public record DTOAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        Endereco endereco) {
}
