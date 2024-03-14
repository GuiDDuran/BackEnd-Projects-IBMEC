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
@RequestMapping("/cliente") // É utilizado para chamar o controller cliente, também irá aparecer na url
public class ClienteController {

    //private static ArrayList<Cliente> repositorio = new ArrayList<>(); // Cria um array cliente.
    @Autowired
    private ClienteRepository repositorio;

    @GetMapping("/listar")  // O get é utilizado para exibir a página ao usuário e o /listar será o endereço da url
    public String listarCliente(Model model) {

        /*Cliente cliente1 = new Cliente();  // Tipo da clase 'Cliente' definida no model e 'cliente' é o nome da classe.
        cliente1.setNome("Guilherme Duran");  // Chama a classe 'cliente' e define os parâmetros de cada campo.
        cliente1.setEmail("guilherme.d.gea@gmail.com");
        cliente1.setCpf("135.512.177-93");
        cliente1.setDataNascimento("20/12/2004");
        repositorio.add(cliente1);*/

        model.addAttribute("listaCliente", repositorio.findAll());  // Liga os dados da model com a página html.

        return "listar-cliente";  // Vai retornar a página html listar-cliente dentro da pasta resources/templates.
    }

    @GetMapping("/adicionar")  // O método Get é utilizado para exibir.
    public String adicionar(Cliente cliente) {
        return "adicionar-cliente";
    }

    @PostMapping("/salvar")  // O método Post é utilizado para salvar.
    public String salvar(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()){
            return "adicionar-cliente";
        }
        repositorio.save(cliente);
        return "redirect:/cliente/listar";

        /*int id = 1;
        if (repositorio.size() > 0) {
            Cliente ultimo = repositorio.get(repositorio.size() - 1);
            id = ultimo.getId() + 1;
        }
        cliente.setId(id);
        repositorio.add(cliente);
        return "redirect:/cliente/listar";  // Após adicionar o cliente, ele é direcionado para a página listar.*/
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        Cliente clienteASerExcluido = repositorio.getById(id);
        repositorio.delete(clienteASerExcluido);
        return "redirect:/cliente/listar";

        /*Cliente clienteASerExcluido = null;
        for (Cliente item : repositorio){
            if (item.getId() == id) {
                clienteASerExcluido = item;
            }
        }
        repositorio.remove(clienteASerExcluido);
        return "redirect:/cliente/listar";*/
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Cliente clienteASerEditado = repositorio.getById(id);
        model.addAttribute("cliente", clienteASerEditado);
        return "editar-cliente";

        /*Cliente clienteASerEditado = null;
        for (Cliente item : repositorio) {
            if (item.getId() == id){
                clienteASerEditado = item;
                break;
            }
        }
        model.addAttribute("cliente", clienteASerEditado);
        return "editar-cliente";*/

        /*Cliente cliente = repositorio.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("cliente", cliente);
        return "editar-cliente"; */
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Cliente newData) {
        Cliente clienteASerEditado = repositorio.getById(id);
        
        /*Cliente clienteASerEditado = null;
        for (Cliente item : repositorio) {
            if (item.getId() == id) {
                clienteASerEditado = item;
                break;
            }
        }*/

        clienteASerEditado.setNome(newData.getNome());
        clienteASerEditado.setCpf(newData.getCpf());
        clienteASerEditado.setEmail(newData.getEmail());
        clienteASerEditado.setDataNascimento(newData.getDataNascimento());
        return "redirect:/cliente/listar";
    }
    /*public String atualizar(@PathVariable("id") int id, @ModelAttribute("cliente") Cliente cliente) {
        for (int i = 0; i < repositorio.size(); i++) {
            if (repositorio.get(i).getId() == id) {
                repositorio.set(i, cliente);
                break;
            }
        }
        return "redirect:/cliente/listar";
    } */
}
