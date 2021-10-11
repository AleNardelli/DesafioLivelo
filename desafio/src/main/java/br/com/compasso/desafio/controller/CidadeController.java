package br.com.compasso.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.desafio.dto.CidadeDto;
import br.com.compasso.desafio.model.Cidade;
import br.com.compasso.desafio.model.Cliente;
import br.com.compasso.desafio.repository.CidadeRepository;
import br.com.compasso.desafio.service.CidadeService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping("/cidade/cadastrar")
	@ApiOperation(value = "Cadastrar Cidade")
	public Cidade cidade(@RequestBody CidadeDto cidadeDto) {
		return cidadeService.cadastrar(cidadeDto);
	}
	
	@GetMapping ("/cidade")
    @ApiOperation(value = "Listagem Completa de Cidades")
    public List<Cidade> listarTodos() {
        return cidadeService.listarTodos();
    } 
	
	@GetMapping("/{nome}")
	@ApiOperation(value = "Busca Cidade por Nome")
	public List<Cidade> buscar(@PathVariable String nome) {
		return cidadeService.buscarPorNome(nome);
	}

}
