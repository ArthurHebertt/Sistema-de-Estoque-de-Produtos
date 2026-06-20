package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.repository;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoModel , Long>{
}
