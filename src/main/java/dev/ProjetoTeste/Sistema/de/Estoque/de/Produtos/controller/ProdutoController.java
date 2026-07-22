package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.controller;

import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.dto.ProdutoDTO;
import dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    public final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {
        return "Bem vindo";
    }

    // Adicionar Produto (CREAT)
    @PostMapping("/adicionar")
    @Operation(summary = "Cria um novo produto", description = "Cria um novo produto e adiciona ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<String> adicionarProduto(
            @Parameter(description = "Usuario manda os dados do produto a ser adicionado no corpo da requisição")
            @RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoService.adicionarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto: " + produtoDTO.getNome() + " adicionado com sucesso");
    }


    // Mostrar todos os Produtos (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os produtos ", description = "Lista todos os produtos salvos no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos"),

    })
    public ResponseEntity<List<ProdutoDTO>> listaDeProdutos() {
        return ResponseEntity.ok(produtoService.listaDeProdutos());
    }


    // Procurar Produto por Id (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um produto pelo ID", description = "Procura um produto no banco de dados pelo ID, e caso encontrado, retorna o produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProdutoDTO> produtoPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarPorId(id));
    }


    // Alterar dados do Produto (UPDATE)
    @PutMapping("/editar/{id}")
    @Operation(summary = "Altera um produto por id", description = "Procura um produto pelo id, e caso encontrado, altera seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto foi atualizado"),
            @ApiResponse(responseCode = "400", description = "produto não encontrado")
    })
    public ResponseEntity<String> editarProduto(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do produto a ser atualizado no corpo da requisição")
            @RequestBody ProdutoDTO produto) {
        produtoService.editarProduto(id, produto);
        return ResponseEntity.ok("Produto " + produto.getNome() + " foi atualizado");

    }


    // Deletar Produto (DELETE)
    @DeleteMapping ("/deletarProduto/{id}")
    @Operation(summary = "Deleta um produto pelo ID", description = "Procura um produto no banco de dados pelo ID, e caso encontrado, deleta o produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })

    public ResponseEntity<String> deletarProduto(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.ok("Produto deletado com Sucesso");
    }

}