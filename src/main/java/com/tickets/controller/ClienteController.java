package com.tickets.controller;

import com.tickets.domain.Cliente;
import com.tickets.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();/*Arrays.asList(cliente1, cliente2, cliente3);*/
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        
        var totalCredito=0;
        for(Cliente c: clientes){
            totalCredito+=c.getCredito().getLimite();
        }
        model.addAttribute("totalCredito", totalCredito);
        return "/cliente/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente,Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }

}
/*var saludo = "Hola desde el Back End";
        model.addAttribute("variable", saludo);*/

 /*Cliente cliente1 = new Cliente("Juan", "Cervantes", "jcervantes@gmail.com", "80689740");
        Cliente cliente2 = new Cliente("Pedro", "Cervantes", "pcervantes@gmail.com", "97264842");
        Cliente cliente3 = new Cliente("Ana", "Cervantes", "acervantes@gmail.com", "78534590");*/
