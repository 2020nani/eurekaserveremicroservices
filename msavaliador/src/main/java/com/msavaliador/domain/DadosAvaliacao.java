package com.msavaliador.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosAvaliacao {
    private String cpf;
    private BigDecimal renda;
}
