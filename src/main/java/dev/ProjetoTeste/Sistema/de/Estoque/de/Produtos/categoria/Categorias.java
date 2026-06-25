package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import jakarta.persistence.*;

import java.nio.MappedByteBuffer;
import java.util.List;


@Entity
@Table (name = "tb_categoria")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria") // uma categoria pode ser composta de varios produtos
    private List<ProdutoModel> produto;
}
