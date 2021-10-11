package br.com.compasso.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.desafio.dto.CidadeDto;
import br.com.compasso.desafio.model.Cidade;
import br.com.compasso.desafio.model.Estado;
import br.com.compasso.desafio.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade cadastrar(CidadeDto cidadeDto) {
		return cidadeRepository.save(cidadeDto.converterToEntity(cidadeDto));
	}
	
	public List<Cidade> listarTodos(){
		return cidadeRepository.findAll();
	}
	
	public List<Cidade> buscarPorNome(String nome) {
		return (List<Cidade>) cidadeRepository.findByNome(nome);
	}

}
