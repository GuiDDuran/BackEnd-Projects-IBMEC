package br.com.ibmec.backend.cadastrocliente.controller;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cliente") // É utilizado para chamar o controller cliente, também irá aparecer na url
public class ClienteController {
    @GetMapping("/listar")  // O get é utilizado para exibir a página ao usuário e o /listar será o endereço da url
    public String listarCliente(Model model) {

        ArrayList<Cliente> lista = new ArrayList<Cliente>();  // Cria um array cliente.

        Cliente cliente1 = new Cliente();  // Tipo da clase 'Cliente' definida no model e 'cliente' é o nome da classe.
        cliente1.setNome("Guilherme Duran");  // Chama a classe 'cliente' e define os parâmetros de cada campo.
        cliente1.setEmail("guilherme.d.gea@gmail.com");
        cliente1.setCpf("135.512.177-93");
        cliente1.setDataNascimento("20/12/2004");
        lista.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Julia Duran");
        cliente2.setEmail("julia.d.gea@gmail.com");
        cliente2.setCpf("123.456.789-10");
        cliente2.setDataNascimento("16/05/2007");
        lista.add(cliente2);

        model.addAttribute("listaCliente", lista);  // Liga os dados da model com a página html.

        return "listar-cliente";  // Vai retornar a página html listar-cliente dentro da pasta resources/templates.
    }
}
