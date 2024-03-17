package br.com.ibmec.backend.cadastrocliente.controller;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;
import br.com.ibmec.backend.cadastrocliente.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping("/listar")
    public String listarCliente(Model model) {
        model.addAttribute("listaCliente", repositorio.findAll());  // Liga os dados da model com a página html.
        return "listar-cliente";
    }

    @GetMapping("/adicionar")
    public String adicionar(Cliente cliente) {
        return "adicionar-cliente";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()){
            return "adicionar-cliente";
        }
        repositorio.save(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        Cliente clienteASerExcluido = repositorio.getById(id);
        repositorio.delete(clienteASerExcluido);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Cliente clienteASerEditado = repositorio.getById(id);
        model.addAttribute("cliente", clienteASerEditado);
        return "editar-cliente";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Cliente newData) {
        Cliente clienteASerEditado = repositorio.getById(id);

        clienteASerEditado.setNome(newData.getNome());
        clienteASerEditado.setCpf(newData.getCpf());
        clienteASerEditado.setEmail(newData.getEmail());
        clienteASerEditado.setDataNascimento(newData.getDataNascimento());

        repositorio.save(clienteASerEditado);
        return "redirect:/cliente/listar";
    }
}
