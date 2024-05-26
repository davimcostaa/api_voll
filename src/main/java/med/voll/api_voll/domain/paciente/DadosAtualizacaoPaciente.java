package med.voll.api_voll.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api_voll.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
