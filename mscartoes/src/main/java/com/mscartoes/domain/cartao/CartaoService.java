package com.mscartoes.domain.cartao;

import com.mscartoes.infra.repository.CartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Component
public class CartaoService {
    private final CartaoRepository cartaoRepository;

    public Cartao cadastrarCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> buscarCartoesPorRenda(BigDecimal renda) {
        return cartaoRepository.findByRendaLessThanEqual(renda);
    }
}
