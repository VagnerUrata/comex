package br.com.alura.comex.controller;

import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.form.ClienteForm;
import br.com.alura.comex.modelo.Cliente;
import br.com.alura.comex.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    @Cacheable(value = "listaTodosClientes")
    public List<ClienteDto> lista() {
        List<Cliente> lista = clienteRepository.findAll();
        return ClienteDto.converter(lista);
    }

    @PostMapping
    @CacheEvict(value = "listaTodosClientes", allEntries = true)
    public ResponseEntity<ClienteForm> cadastrarCliente(@RequestBody @Valid ClienteForm form) {
        Cliente cliente = form.converter();
        this.clienteRepository.save(cliente);

        return ResponseEntity.ok(form);
    }
}