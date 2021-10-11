package br.com.compasso.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.compasso.desafio.dto.ClienteDto;
import br.com.compasso.desafio.model.Cliente;
import br.com.compasso.desafio.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Cliente cadastrar(ClienteDto clienteDto) {
		return clienteRepository.save(clienteDto.converterToEntity(clienteDto));
	}
	
	public Cliente buscarPorNome(String nome) {
		Optional<Cliente> clienteByNome = clienteRepository.findByNome(nome);
    	if(clienteByNome.isPresent()) {
    		return clienteByNome.get();
    	}
    	return null;
	}
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
    public Cliente procurarPorId(long id) {
    	return clienteRepository.findById(id);
    }
    
  
 /*   public ClienteDto atualizaCliente(String nome, String novoNome) {
    	Cliente buscarPorNome = buscarPorNome(nome);
    	if(buscarPorNome != null) {
    		ClienteDto clienteDto = new ClienteDto();
    		buscarPorNome.setNome(novoNome);
    		clienteRepository.save(buscarPorNome);
    		return clienteDto.converterToDto(buscarPorNome);
    	}
    	return null; 
 		
    } */
	
	public void remover(Long id) {
    	Optional<Cliente> optional = clienteRepository.findById(id);
    	if (optional.isPresent()) {
    		clienteRepository.deleteById(id);
    	}
	}

}
