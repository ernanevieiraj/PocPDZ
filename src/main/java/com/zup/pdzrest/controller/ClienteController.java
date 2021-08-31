package com.zup.pdzrest.controller;

import com.zup.pdzrest.Model.Cliente;
import com.zup.pdzrest.functions.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.zup.pdzrest.repository.ClienteRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//Classe que recebe requisições
@RestController
//Anotação para dizer que recebe requisições no endereço /clientes
@RequestMapping("/clientes")
public class ClienteController {

    //Adiciona instancia automaticamente
    @Autowired(required=true)
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> listarCliente(@PathVariable Long id){
        return clienteRepository.findById(id);
    }

    //RequestBody serve para transformar o corpo da requisicao em um objeto cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionarCliente(@RequestBody @Valid Cliente cliente){
        cliente.setSegmento();
        return clienteRepository.save(cliente);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable @Valid Long id){
        clienteRepository.deleteById(id);
    }

    @PutMapping
    public Cliente atualizarCliente(@RequestBody @Valid Cliente cliente){
        cliente.setSegmento();
        return clienteRepository.save(cliente);
    }

}