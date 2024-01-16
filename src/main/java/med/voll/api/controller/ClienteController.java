package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Repository.IClienteRepository;
import med.voll.api.cliente.DTOAtualizarCliente;
import med.voll.api.cliente.DadosCadastroCliente;
import med.voll.api.cliente.ListagemDeClientes;
import med.voll.api.cliente.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @PostMapping
    public void dadadosCliente(@RequestBody @Valid DadosCadastroCliente DadosCliente) {
        clienteRepository.save(new cliente(DadosCliente));
    }

    @GetMapping
    public Page<ListagemDeClientes> listaCliente(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return clienteRepository.findAllAtivoTrue(paginacao).map(ListagemDeClientes::new);
    }

    @PutMapping
    @Transactional
    public void AtualizarCliente(@RequestBody @Valid DTOAtualizarCliente DadosCliente) {
        var cliente = clienteRepository.getReferenceById(DadosCliente.id());
        cliente.atualizarInformacao(DadosCliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void ApagarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional

    public void excluirCliente(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        cliente.ExcluirCliente();
    }


}
