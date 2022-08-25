package com.msavaliador.infra.clients;

import com.msavaliador.domain.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mscliente",path = "/v1/api/cliente")
public interface ConsultaDadosCliente {

    @GetMapping("/{cpf}")
    Cliente buscarClientePorCpf(@PathVariable String cpf);
}
