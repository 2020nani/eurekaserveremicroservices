package com.msavaliador.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class RetornoAvaliacaoCliente {
    List<CartaoAprovado> cartaoAprovadoList;
}
