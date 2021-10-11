package br.com.compasso.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.desafio.dto.EstadoDto;
import br.com.compasso.desafio.model.Cliente;
import br.com.compasso.desafio.model.Estado;
import br.com.compasso.desafio.repository.EstadoRepository;
import br.com.compasso.desafio.service.EstadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired 
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	@PostMapping("/estado/cadastrar")
	@ApiOperation(value = "Cadastrar Estado")
	public Estado estado(@RequestBody EstadoDto estadoDto) {
	return estadoService.cadastrar(estadoDto);

	}
	
	@GetMapping ("/estado")
	@ApiOperation(value = "Listagem Completa de Estados")
	public List<Estado> listarTodos() {
      return estadoService.listarTodos();
  } 
	
	@GetMapping("/{nome}")
	@ApiOperation(value = "Busca Estado por Nome")
	public List<Estado> buscar(@PathVariable String nome) {
		return estadoService.buscarPorNome(nome);
	}
}
