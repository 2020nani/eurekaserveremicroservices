package com.mscartoes.domain.cliente;

import com.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;
    public List<ClienteCartao> listaClienteCartaoPorCpf(String cpf){
        return clienteCartaoRepository.findByCpf(cpf);
    }
}
