package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/categorias")
public class CategoriaController {

    @PostMapping("/criarCategoria")
    public String criarCategoria() {
        return "categoria criada";
    }

    @PutMapping("/alterarCategoria")
    public String alterarCategoria() {
        return "categoria alterada";
    }

    @GetMapping("/listarCategoria")
    public String listarCategoria() {
        return "Lisda de categorias";
    }

    @DeleteMapping("/deletarCategoria")
    public String deletarCategoria() {
        return "categoria deletada";
    }

}
