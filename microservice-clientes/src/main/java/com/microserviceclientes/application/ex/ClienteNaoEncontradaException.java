package com.microserviceclientes.application.ex;

public class ClienteNaoEncontradaException extends RuntimeException {
    public ClienteNaoEncontradaException(String message) {
        super(message);
    }
}
