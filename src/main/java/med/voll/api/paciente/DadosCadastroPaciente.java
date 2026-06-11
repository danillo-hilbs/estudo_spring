package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroPaciente(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Idade é obrigatória")
        @Min(value = 0,   message = "Idade não pode ser negativa")
        @Max(value = 120, message = "Idade implausível")
        Integer idade,

        @NotBlank(message = "Telefone é obrigatório")
        @Pattern(regexp = "\\d{10,11}", message = "Telefone deve ter 10 ou 11 dígitos")
        String telefone,

        @NotNull(message = "Plano de saúde é obrigatório")
        PlanoDeSaude planoDeSaude
) {}