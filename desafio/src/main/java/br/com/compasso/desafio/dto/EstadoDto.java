package br.com.compasso.desafio.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.desafio.model.Estado;

public class EstadoDto {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estado converterToEntity(EstadoDto estadoDto) {
		Estado estado = new Estado();
		estado.setNome(estadoDto.getNome());
		return estado;
	}
	
	public EstadoDto converterToDto(Estado estado) {
		EstadoDto estadoDto = new EstadoDto();
		estadoDto.setNome(estadoDto.getNome());
		return estadoDto;
	}
	
	public List<EstadoDto> converterToDto(List<Estado> estadoList){
		return estadoList.stream().map(estado -> converterToDto(estado)).collect(Collectors.toList());
	}

}
