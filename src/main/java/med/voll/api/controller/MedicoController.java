package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Repository.IMedicoRepository;
import med.voll.api.medico.DTOAtualizarMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos:: new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DTOAtualizarMedico dados){

        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarMedico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.ExcluirMedico();
    }

    
}
