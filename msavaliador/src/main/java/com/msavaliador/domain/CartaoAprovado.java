package com.msavaliador.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoAprovado {
    private String cartao;
    private String bandeira;
    private BigDecimal limiteAprovado;

    public CartaoAprovado(Cartao cartao) {
        this.cartao = cartao.getNome();
        this.bandeira = cartao.getBandeiraCartao();
        this.limiteAprovado = cartao.getLimiteLiberado();
    }
}
