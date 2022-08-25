package com.msavaliador.domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ClienteCartao {
    private String cpf;
    private Cartao cartao;
    private BigDecimal limiteLiberado;
}
