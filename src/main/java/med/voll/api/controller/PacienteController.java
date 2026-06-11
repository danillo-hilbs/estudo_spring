package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente){
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }

    @GetMapping
    @Transactional
    public Page<DadosListagemPaciente> listar(Pageable paginacao){
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public DadosListagemPaciente atualizar(@RequestBody @Valid DadosAtualizarPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizar(dados);
        return new DadosListagemPaciente(paciente);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.desativar();
    }

}
