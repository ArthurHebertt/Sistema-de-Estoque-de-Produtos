package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/criarCategoria")
    public ResponseEntity<String> criarCategoria(@RequestBody Categorias categorias) {
        categoriaService.adicionar(categorias);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria " + categorias.getNome() + " foi criada");
    }

    @GetMapping("/listarCategoria")
    public ResponseEntity<List<Categorias>> listarCategoria() {
        return ResponseEntity.ok(categoriaService.lista());
    }

    @GetMapping("/listarCategoria/{id}")
    public ResponseEntity<Categorias> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.listarPorId(id));
    }

    @PutMapping("/editarCategoria/{id}")
    public ResponseEntity<String> editarCategoria(@PathVariable Long id, @RequestBody Categorias categorias) {
        categoriaService.editar(id,categorias);
        return ResponseEntity.ok("Categoria " + categorias.getNome() + " foi editada");
    }

    @DeleteMapping("/deletarCategoria/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.ok("Categoria deletada");
    }

}
