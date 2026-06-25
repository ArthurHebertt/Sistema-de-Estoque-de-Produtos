package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria.Categorias;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_produtos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProdutoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String descricao;

    private Integer preco;

    private int quantidade;

    @ManyToOne // Um produto tem uma unica categoria
    @JoinColumn(name = "categoria_id") // Foreing Key
    private Categorias categoria;

}
