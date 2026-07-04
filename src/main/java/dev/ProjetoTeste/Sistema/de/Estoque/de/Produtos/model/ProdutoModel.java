package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria.Categorias;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_produtos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProdutoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column (name = "descrição")
    private String descricao;

    @Column(name = "preço")
    private BigDecimal preco;

    @Column(name = "quantidade")
    private int quantidade;

    @ManyToOne // Um produto tem uma unica categoria
    @JoinColumn(name = "categoria_id") // Foreing Key
    private Categorias categoria;

}
