package br.com.compasso.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.desafio.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	List<Estado> findByNome(String estado);

}
