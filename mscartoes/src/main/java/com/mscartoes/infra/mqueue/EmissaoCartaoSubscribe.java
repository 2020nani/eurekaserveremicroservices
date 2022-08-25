package com.mscartoes.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mscartoes.domain.cartao.Cartao;
import com.mscartoes.domain.cartao.DadosSolicitacaoEmissaoCartao;
import com.mscartoes.domain.cliente.ClienteCartao;
import com.mscartoes.infra.repository.CartaoRepository;
import com.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscribe {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emisao-cartao}")
    public void receberSolicitacaoEmissao(String payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload,DadosSolicitacaoEmissaoCartao.class);
        Cartao cartao = cartaoRepository.findById(dados.getIdCartao())
                .orElseThrow(() -> new NoSuchElementException("Nao existe cartao"));
        ClienteCartao clienteCartao = new ClienteCartao();
        clienteCartao.setCpf(dados.getCpf());
        clienteCartao.setCartao(cartao);
        clienteCartao.setLimite(dados.getLimiteLiberado());
        clienteCartaoRepository.save(clienteCartao);
    }
}
