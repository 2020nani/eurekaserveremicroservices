package com.msavaliador.infra.clients;

import com.msavaliador.domain.Cartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(value = "mscartoes",path = "/v1/api/cartao")
public interface ConsultaCartaoCliente {

    @GetMapping("/cliente/{cpf}")
    public List<Cartao> listaCartaoClientePorCpf(@PathVariable String cpf);

    @GetMapping("/{renda}")
    public List<Cartao> listaCartaoPorRendaMenorIgual(@PathVariable BigDecimal renda);
}
