package com.msavaliador.domain;

import com.msavaliador.apllication.ex.ClienteNotFoundException;
import com.msavaliador.infra.clients.ConsultaCartaoCliente;
import com.msavaliador.infra.clients.ConsultaDadosCliente;
import com.msavaliador.infra.mqueues.SolicitacaoEmissaoCartaoPublisher;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class AvaliadorCreditoService {

    private final ConsultaDadosCliente consultaDadosCliente;
    private final ConsultaCartaoCliente consultaCartaoCliente;
    private final SolicitacaoEmissaoCartaoPublisher publisher;

    public SituacaoCliente obterSituacaoCliente(String cpf){
        try {
            Cliente dadosCliente = consultaDadosCliente.buscarClientePorCpf(cpf);
            List<Cartao> cartaoList = consultaCartaoCliente.listaCartaoClientePorCpf(cpf);

            return SituacaoCliente.builder()
                    .dadosCliente(dadosCliente)
                    .cartoes(cartaoList)
                    .build();
        }catch (FeignException.FeignClientException e){
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status){
                throw new ClienteNotFoundException("Cliente cpf: " + cpf + " nao encontrado");
            }
            throw new IllegalArgumentException("Erro inesperado");
        }

    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, BigDecimal renda){
        Cliente dadosCliente = consultaDadosCliente.buscarClientePorCpf(cpf);
        List<Cartao> cartaoList = consultaCartaoCliente.listaCartaoPorRendaMenorIgual(renda);

        return RetornoAvaliacaoCliente
                .builder()
                .cartaoAprovadoList(cartaoList.stream().map(CartaoAprovado::new).collect(Collectors.toList()))
                .build();
    }

    public String solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados){
        try {
            publisher.solicitarCartao(dados);
            log.info("gerando protocolo");
            return UUID.randomUUID().toString();
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
