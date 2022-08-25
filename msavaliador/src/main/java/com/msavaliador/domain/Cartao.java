package com.msavaliador.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartao {
    private Long id;
    private String nome;
    @JsonProperty("bandeira")
    private String bandeiraCartao;
    @JsonProperty("limite")
    private BigDecimal limiteLiberado;
}
