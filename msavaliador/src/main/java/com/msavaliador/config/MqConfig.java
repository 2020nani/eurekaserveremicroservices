package com.msavaliador.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Value("${mq.queues.emisao-cartao}")
    private String emissaoCartoes;

    @Bean
    public Queue queueEmissaoCartao(){
        return new Queue(emissaoCartoes,true);
    }
}
