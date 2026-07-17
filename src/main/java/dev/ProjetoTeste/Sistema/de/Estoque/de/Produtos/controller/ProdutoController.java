package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.controller;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.dto.ProdutoDTO;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.model.ProdutoModel;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    public ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem vindo";
    }

    // Adicionar Produto (CREAT)
    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoService.adicionarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto: " + produtoDTO.getNome() + " adicionado com sucesso");
    }


    // Mostrar todos os Produtos (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listaDeProdutos() {
        return ResponseEntity.ok(produtoService.listaDeProdutos());
    }


    // Procurar Produto por Id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoDTO> produtoPorid(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarPorId(id));
    }


    // Alterar dados do Produto (UPDATE)
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produto) {
        produtoService.editarProduto(id, produto);
        return ResponseEntity.ok("Produto " + produto.getNome() + " foi atualizado");

    }


    // Deletar Produto (DELETE)
    @DeleteMapping ("/deletarProduto/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.ok("Produto deletado com Sucesso");
    }

}