package med.voll.api.cliente;

import med.voll.api.Endereco.DadosEndereco;

public record DadosCadastroCliente (String nome, String email, String telefone, String CPF, DadosEndereco endereco){
}
