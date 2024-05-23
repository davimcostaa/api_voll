package med.voll.api_voll.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api_voll.paciente.DadosCadastroPaciente;
import med.voll.api_voll.paciente.DadosListagemPaciente;
import med.voll.api_voll.paciente.Paciente;
import med.voll.api_voll.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @GetMapping
    public Page<DadosListagemPaciente> listar( @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao ) {
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}
