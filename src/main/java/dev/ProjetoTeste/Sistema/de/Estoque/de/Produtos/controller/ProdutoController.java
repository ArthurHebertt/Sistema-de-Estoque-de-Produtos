package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProdutoController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem vindo";
    }

    //

}
