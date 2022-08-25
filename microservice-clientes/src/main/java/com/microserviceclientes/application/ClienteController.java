package com.microserviceclientes.application;

import com.microserviceclientes.domain.Cliente;
import com.microserviceclientes.domain.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("cliente/{cpf}")
    public Cliente buscarClientePorCpf(@PathVariable String cpf){
        return clienteService.buscarClientePorCpf(cpf);
    }
}
