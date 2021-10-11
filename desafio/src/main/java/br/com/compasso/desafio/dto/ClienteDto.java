package br.com.compasso.desafio.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.desafio.model.Cliente;

public class ClienteDto {
	
	private String nome;
	private char sexo;
	private LocalDate dataNascimento;
	private int idade;
	


	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente converterToEntity(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setNome(clienteDto.getNome());
		cliente.setDataNascimento(clienteDto.getDataNascimento());
		cliente.setIdade(clienteDto.getIdade());
		cliente.setSexo(clienteDto.getSexo());
		return cliente;
	}
	
	public ClienteDto converterToDto(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNome(cliente.getNome());
		clienteDto.setDataNascimento(cliente.getDataNascimento());
		clienteDto.setIdade(cliente.getIdade());
		clienteDto.setSexo(cliente.getSexo());
		return clienteDto;
	}
	
	
	public List<ClienteDto> converterToDto(List<Cliente> clienteList){
		return clienteList.stream().map(cliente -> converterToDto(cliente)).collect(Collectors.toList());
	}
	

}
