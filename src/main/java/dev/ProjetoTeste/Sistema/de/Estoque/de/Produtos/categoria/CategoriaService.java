package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // adicionar
    public Categorias adicionar(Categorias categorias) {
        return categoriaRepository.save(categorias);
    }

    // Listar
    public List<Categorias> lista () {
        return categoriaRepository.findAll();
    }

    // Listar Por id
    public Categorias listarPorId (Long id) {
        return categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
    }

    // editar por id
    public Categorias editar (Long id, Categorias categorias) {
        categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
        categorias.setId(id);
        return categoriaRepository.save(categorias);

    }

    // deletar por id
    public void deletar(Long id) {
        categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
        categoriaRepository.deleteById(id);
    }

}
