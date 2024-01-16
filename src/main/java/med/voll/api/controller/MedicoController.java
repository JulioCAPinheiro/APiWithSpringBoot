package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Repository.IMedicoRepository;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private IMedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public void cadastroMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }


}
