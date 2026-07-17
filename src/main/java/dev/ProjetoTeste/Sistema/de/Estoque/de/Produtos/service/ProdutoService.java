package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.service;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.dto.ProdutoDTO;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.mapper.ProdutoMapper;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProdutoService {

    public ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    // Adicionar produto
    public ProdutoDTO adicionarProduto (ProdutoDTO produtoDTO) {
        ProdutoModel produto = produtoMapper.map(produtoDTO);
       produto = produtoRepository.save(produto);
       return produtoMapper.map(produto);
    }

    // Listar produtos
    public List<ProdutoDTO> listaDeProdutos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());
    }

    // Listar produtos por ID
    public ProdutoDTO listarPorId(Long id) {
        ProdutoModel produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        return produtoMapper.map(produto);
   }

    // Editar produto

    public ProdutoDTO editarProduto (Long id, ProdutoDTO produtoDTO) {
        Optional<ProdutoModel> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutoModel produtoEditado = produtoMapper.map(produtoDTO);
            produtoEditado.setId(id);
            ProdutoModel produtoSalvo = produtoRepository.save(produtoEditado);
            return produtoMapper.map(produtoSalvo);
        } return null;
    }


    // Deletar produto
    public void deletarProduto(Long id) {
        produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        produtoRepository.deleteById(id);
    }




}