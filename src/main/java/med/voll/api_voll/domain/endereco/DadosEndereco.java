package med.voll.api_voll.domain.endereco;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotNull
        String logradouro,

        @NotNull
        String bairro,

        @NotNull
                @Pattern(regexp = "\\d{8}")
        String cep,

        @NotNull
        String cidade,

        @NotNull
        String uf,
        String complemento,
        String numero
) {
}
