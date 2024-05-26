package med.voll.api_voll.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api_voll.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

            @NotNull
            Long id,
            String nome,
            String telefone,
            DadosEndereco endereco) {

}
