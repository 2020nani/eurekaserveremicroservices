package com.mscartoes.apllication;

import com.mscartoes.domain.cartao.Cartao;
import com.mscartoes.domain.cartao.CartaoService;
import com.mscartoes.domain.cliente.ClienteCartaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CartaoController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping("cartao")
    public String testeConexao(){
        return "ok";
    }

    @PostMapping("cartao")
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao cadastrarCartao(@RequestBody Cartao cartao){
        return cartaoService.cadastrarCartao(cartao);
    }

    @GetMapping("cartao/{renda}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cartao> listaCartaoPorRendaMenorIgual(@PathVariable BigDecimal renda){
        return cartaoService.buscarCartoesPorRenda(renda);
    }

    @GetMapping("cartao/cliente/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartoesPorClienteResponse> listaCartaoPorCpf(@PathVariable String cpf){
        return clienteCartaoService.listaClienteCartaoPorCpf(cpf)
                .stream()
                .map(CartoesPorClienteResponse::new)
                .collect(Collectors.toList());
    }
}
