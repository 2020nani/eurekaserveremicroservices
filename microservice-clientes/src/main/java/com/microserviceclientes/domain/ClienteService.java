package com.microserviceclientes.domain;

import com.microserviceclientes.application.ex.ClienteNaoEncontradaException;
import com.microserviceclientes.infra.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Component
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf){
        return clienteRepository.findByCpf(cpf).orElseThrow(() -> new ClienteNaoEncontradaException("Erro ao buscar dados"));
    }
}
