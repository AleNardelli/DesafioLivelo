package br.com.compasso.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.desafio.dto.ClienteDto;
import br.com.compasso.desafio.model.Cliente;
import br.com.compasso.desafio.repository.ClienteRepository;
import br.com.compasso.desafio.service.ClienteService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cliente/cadastrar")
	@ApiOperation(value = "Cadastrar Cliente")
	public Cliente cliente(@RequestBody ClienteDto clienteDto) {
		return clienteService.cadastrar(clienteDto);
	}
	
	@GetMapping ("/cliente")
	@ApiOperation(value = "Listagem Completa de Clientes")
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    } 
	
	@GetMapping("/{nome}")
	@ApiOperation(value = "Busca Cliente por Nome")
	public Cliente buscar(@PathVariable String nome) {
		return clienteService.buscarPorNome(nome);
	}
	
	@GetMapping("/listar/{id}")
    @ApiOperation(value = "Busca Cliente por Id")
    public Cliente listarId(@PathVariable Long id) {
    	return clienteService.procurarPorId(id);
    }
	
/*	@PutMapping("/atualizar")
    @ApiOperation(value = "Atualiza cliente")
    public ClienteDto atualizaCliente(@RequestBody String nome, String novoNome) {
    	return clienteService.atualizaCliente(nome, novoNome);
    } */
	
	 @PutMapping("/atualizar")
	    @ApiOperation(value = "Atualiza cliente")
	    public Cliente atualizaCliente(@RequestBody Cliente cliente) {
	    	return clienteRepository.save(cliente);
	    } 
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar Cliente por Id")
	public void deletarCliente(@PathVariable Long id) {
	clienteService.remover(id);
	
	}

}
