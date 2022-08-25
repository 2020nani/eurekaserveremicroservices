package com.msavaliador.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SituacaoCliente {
    private Cliente dadosCliente;
    private List<Cartao> cartoes;
}
