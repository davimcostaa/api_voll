package med.voll.api_voll.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api_voll.medico.DadosCadastroMedico;
import med.voll.api_voll.medico.DadosListagemMedico;
import med.voll.api_voll.medico.Medico;
import med.voll.api_voll.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public Page<DadosListagemMedico> listar( @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao ) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }


}
