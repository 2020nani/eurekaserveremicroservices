package com.msavaliador.apllication;

import com.msavaliador.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping("avaliacao")
    public String testeConexao(){
        return "ok";
    }

    @GetMapping("avaliacao/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public SituacaoCliente consultaAvaliacaoCliente(@PathVariable String cpf){
        return avaliadorCreditoService.obterSituacaoCliente(cpf);
    }

    @PostMapping("avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public RetornoAvaliacaoCliente realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao){
        return avaliadorCreditoService.realizarAvaliacao(dadosAvaliacao.getCpf(),dadosAvaliacao.getRenda());
    }

    @PostMapping("avaliacao/solicitar-cartao")
    @ResponseStatus(HttpStatus.CREATED)
    public String realizarAvaliacao(@RequestBody DadosSolicitacaoEmissaoCartao dados){
        return avaliadorCreditoService.solicitarEmissaoCartao(dados);
    }
}
