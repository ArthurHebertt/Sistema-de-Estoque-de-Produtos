package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria.Categorias;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_estoque")
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

    public ProdutoModel(Long id, String nome, String descricao, Integer preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
