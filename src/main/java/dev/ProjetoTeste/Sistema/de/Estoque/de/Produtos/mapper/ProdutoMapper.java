package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.mapper;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.dto.ProdutoDTO;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoModel map(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoDTO.getId());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setDescricao(produtoDTO.getDescricao());
        produtoModel.setPreco(produtoDTO.getPreco());
        produtoModel.setQuantidade(produtoDTO.getQuantidade());
        produtoModel.setCategoria(produtoDTO.getCategoria());
        produtoModel.setImgUrl(produtoDTO.getImgUrl());

        return produtoModel;
    }

    public ProdutoDTO map(ProdutoModel produtoModel) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNome(produtoModel.getNome());
        produtoDTO.setDescricao(produtoModel.getDescricao());
        produtoDTO.setPreco(produtoModel.getPreco());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        produtoDTO.setCategoria(produtoModel.getCategoria());
        produtoDTO.setImgUrl(produtoModel.getImgUrl());

        return produtoDTO;
    }


}
