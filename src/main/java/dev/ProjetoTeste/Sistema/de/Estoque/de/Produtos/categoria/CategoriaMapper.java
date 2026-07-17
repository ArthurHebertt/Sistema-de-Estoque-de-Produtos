package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;

import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categorias map(CategoriaDTO categoriaDTO) {
        Categorias categorias = new Categorias();
        categorias.setId(categoriaDTO.getId());
        categorias.setNome(categoriaDTO.getNome());
        categorias.setProduto(categoriaDTO.getProduto());
        return categorias;
    }

    public CategoriaDTO map(Categorias categorias) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categorias.getId());
        categoriaDTO.setNome(categorias.getNome());
        categoriaDTO.setProduto(categorias.getProduto());
        return categoriaDTO;
    }


}
