package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String telefone;
    @Enumerated(EnumType.STRING)
    @Column(name = "plano")
    private PlanoDeSaude planoDeSaude;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){
        this.idade = dadosCadastroPaciente.idade();
        this.telefone = dadosCadastroPaciente.telefone();
        this.nome = dadosCadastroPaciente.nome();
        this.planoDeSaude = dadosCadastroPaciente.planoDeSaude();
        this.ativo = true;
    }

    public void atualizar(@Valid DadosAtualizarPaciente dados) {
        if(dados.planoDeSaude() != null){
            this.planoDeSaude = dados.planoDeSaude();
        }

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
