package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.dto;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria.Categorias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTO {


    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
    private Categorias categoria;
    private String imgUrl;


}
