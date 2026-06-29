package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProdutoController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem vindo";
    }

    // Adicionar Produto (CREAT)
    @PostMapping("/adicionar")
    public String adicionarProduto() {
        return "Produto adicionado";
    }


    // Mostrar todos os Produtos (READ)
    @GetMapping("/todosOsProdutos")
    public String todosOsProdutos() {
        return "Listar todos os produtos";
    }


    // Procurar Produto por Id (READ)
    @GetMapping("/produtoPorId")
    public String produtoPorId() {
        return "Produto achado";
    }

    // Alterar dados do Produto (UPDATE)
    @PutMapping ("/alterarProdutoId")
    public String alterarPorId () {
        return "Produto atualizado";
    }


    // Deletar Produto (DELETE)
    @DeleteMapping ("/deletarProdutoPorId")
    public String deletarPorId() {
        return "produto deletado";
    }



}
