package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Repository.IClienteRepository;
import med.voll.api.cliente.DadosCadastroCliente;
import med.voll.api.cliente.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;
    @PostMapping
    public void dadadosCliente(@RequestBody @Valid DadosCadastroCliente DadosCliente){
        clienteRepository.save(new cliente(DadosCliente));
    }

}
