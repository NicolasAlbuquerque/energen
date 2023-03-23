package com.generation.energen.repository;

import com.generation.energen.model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeContainingIgnoreCase (@Param("nome") String nome);
	
	public List<Produto> findAllByMarcaContainingIgnoreCase (@Param("marca") String marca);

}
