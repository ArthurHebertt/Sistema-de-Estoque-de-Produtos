package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {

    private Long id;

    private String nome;

    private List<ProdutoModel> produto;
}

