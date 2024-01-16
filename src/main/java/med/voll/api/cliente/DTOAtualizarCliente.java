package med.voll.api.cliente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.Endereco;

public record DTOAtualizarCliente(@NotNull Long id, String nome, String telefone, Endereco endereco) {

}
