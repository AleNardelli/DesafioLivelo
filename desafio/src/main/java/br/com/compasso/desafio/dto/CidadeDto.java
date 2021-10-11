package br.com.compasso.desafio.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.desafio.model.Cidade;


public class CidadeDto {
	
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cidade converterToEntity(CidadeDto cidadeDto) {
		Cidade cidade = new Cidade();
		cidade.setNome(cidadeDto.getNome());
		return cidade;
	}
	
	public CidadeDto converterToDto(Cidade cidade) {
		CidadeDto cidadeDto = new CidadeDto();
		cidadeDto.setNome(cidade.getNome());
		return cidadeDto;
	}
	
	public List<CidadeDto> converterToDto(List<Cidade> cidadeList){
		return cidadeList.stream().map(cidade -> converterToDto(cidade)).collect(Collectors.toList());
	}

}
