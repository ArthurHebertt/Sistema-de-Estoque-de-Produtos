package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.controller;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.dto.ProdutoDTO;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos/ui")
public class ProdutoControllerUI {

    private final ProdutoService produtoService;

    public ProdutoControllerUI(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public String listaDeProdutos(Model model) {
        List<ProdutoDTO> produto = produtoService.listaDeProdutos();
        model.addAttribute("produtos", produto);
        return "listarProdutos";

    }

    @GetMapping("/adicionar")
    public String novoProduto (Model model) {
        model.addAttribute("produto", new ProdutoDTO());
        return "cadastrarProduto";
    }

    @PostMapping("/criar")
    public String criar (ProdutoDTO produtoNovo) {
        produtoService.adicionarProduto(produtoNovo);
        return "redirect:/produtos/ui/listar";
    }

    @GetMapping ("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        ProdutoDTO produto = produtoService.listarPorId(id);
        model.addAttribute("produto", produto);

        return "editarProduto";
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable Long id, @ModelAttribute ProdutoDTO produtoDTO){
        produtoService.editarProduto(id, produtoDTO);

        return "redirect:/produtos/ui/listar";
    }

    @GetMapping("/deletarProduto/{id}")
    public String deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return "redirect:/produtos/ui/listar";
    }







}
