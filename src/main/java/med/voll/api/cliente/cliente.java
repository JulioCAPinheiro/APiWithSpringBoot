package med.voll.api.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Endereco.Endereco;

@Table(name = "clientes")
@Entity(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public cliente(DadosCadastroCliente dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco((dados.endereco()));
    }

    public void atualizarInformacao(DTOAtualizarCliente dadosCliente) {
        if(dadosCliente.nome() != null){
            this.nome = dadosCliente.nome();
        }

        if(dadosCliente.telefone() != null){
            this.telefone = dadosCliente.telefone();
        }

        if(dadosCliente.endereco() != null){
            this.endereco.atualizarInformacoes(dadosCliente.endereco());
        }
    }

    public void ExcluirCliente() {
        this.ativo = false;
    }
}
