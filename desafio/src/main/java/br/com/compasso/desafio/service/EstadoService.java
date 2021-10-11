package br.com.compasso.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.desafio.dto.EstadoDto;
import br.com.compasso.desafio.model.Cliente;
import br.com.compasso.desafio.model.Estado;
import br.com.compasso.desafio.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado cadastrar(EstadoDto estadoDto) {
		return estadoRepository.save(estadoDto.converterToEntity(estadoDto));
		
	}
	
	public List<Estado> listarTodos(){
		return estadoRepository.findAll();
	}
	
	public List<Estado> buscarPorNome(String nome) {
		return (List<Estado>) estadoRepository.findByNome(nome);
	}

}
