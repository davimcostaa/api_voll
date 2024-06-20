package med.voll.api_voll.domain.consulta.validacoes.cancelamento;

import med.voll.api_voll.domain.ValidacaoException;
import med.voll.api_voll.domain.consulta.ConsultaRepository;
import med.voll.api_voll.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioCancelamento implements ValidadorCancelamentoDeConsulta {

    private ConsultaRepository repository;
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());

        var dataConsulta = consulta.getData();
        var agora = LocalDateTime.now();

        var diferencaEmHoras = Duration.between(agora, dataConsulta).toHours();

        if(diferencaEmHoras < 24) {
            throw new ValidacaoException("Consultas só podem ser canceladas com antecedência mínima de 24 horas");
        }


    }
}
