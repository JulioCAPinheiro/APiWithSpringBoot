package med.voll.api.cliente;

public record ListagemDeClientes(Long id,String nome, String email, String cpf) {

    public ListagemDeClientes (cliente clientes){
        this(clientes.getId(),clientes.getNome(), clientes.getEmail(), clientes.getCpf());
    }
}
