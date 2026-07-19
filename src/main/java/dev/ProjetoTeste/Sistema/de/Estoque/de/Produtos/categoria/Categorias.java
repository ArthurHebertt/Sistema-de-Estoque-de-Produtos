package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table (name = "tb_categoria")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria") // uma categoria pode ser composta de varios produtos
    @JsonIgnore // evitar looping de serializacao
    private List<ProdutoModel> produto;
}
