package com.mscartoes.apllication;

import com.mscartoes.domain.cliente.ClienteCartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartoesPorClienteResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limite;

    public CartoesPorClienteResponse(ClienteCartao clienteCartao) {
        this.nome = clienteCartao.getCartao().getNome();
        this.bandeira = clienteCartao.getCartao().getBandeiraCartao().toString();
        this.limite = clienteCartao.getLimite();
    }
}
