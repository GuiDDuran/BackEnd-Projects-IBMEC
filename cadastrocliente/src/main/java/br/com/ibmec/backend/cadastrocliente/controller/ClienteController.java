package br.com.ibmec.backend.cadastrocliente.controller;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;

public class ClienteController {
    public void usaCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Guilherme Duran");

        String nome = cliente.getNome();
    }
}
