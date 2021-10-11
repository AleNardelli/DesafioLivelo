package br.com.compasso.desafio.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import br.com.compasso.desafio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findById(long id);
	
	Optional<Cliente> findByNome(String nome);


	
	

}
