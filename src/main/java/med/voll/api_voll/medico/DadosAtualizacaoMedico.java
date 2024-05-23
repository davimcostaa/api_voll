package med.voll.api_voll.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api_voll.endereco.DadosEndereco;
import med.voll.api_voll.endereco.Endereco;

public record DadosAtualizacaoMedico(

            @NotNull
            Long id,
            String nome,
            String telefone,
            DadosEndereco endereco) {

}
