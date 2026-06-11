package med.voll.api.paciente;


public record DadosListagemPaciente(String nome, Integer idade, PlanoDeSaude planoDeSaude, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getIdade(), paciente.getPlanoDeSaude(), paciente.getTelefone());
    }
}
