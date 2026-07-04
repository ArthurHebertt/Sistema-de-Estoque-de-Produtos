package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.service;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {

    public ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Adicionar produto
    public ProdutoModel adicionarProduto (ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    // Listar produtos
    public List<ProdutoModel> listaDeProdutos() {
        return produtoRepository.findAll();
    }

    // Listar produtos por ID
    public ProdutoModel listarPorId(Long id) {
         return produtoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Produto não encontraado"));
   }
//  outra altertativa para procurar por ID
//    public ProdutoModel listarPorId(Long id) {
//        Optional<ProdutoModel> produtoModel = produtoRepository.findById(id);
//        return produtoModel.orElse(null);
//    }

    // Editar Produto retornando null
//    public ProdutoModel editarProduto(Long id, ProdutoModel produto) {
//        if (produtoRepository.existsById(id)){
//            produto.setId(id);
//            return produtoRepository.save(produto);
//        } else return null;

    // Editar produto

    public ProdutoModel editarProduto(Long id, ProdutoModel produto) {
        produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    // Deletar produto
    public void deletarProduto(Long id) {
        produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        produtoRepository.deleteById(id);
    }




}