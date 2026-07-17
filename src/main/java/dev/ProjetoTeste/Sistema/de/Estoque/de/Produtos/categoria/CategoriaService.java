package dev.ProjetoTeste.Sistema.de.Estoque.de.Produtos.categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    // adicionar
    public CategoriaDTO adicionar (CategoriaDTO categoriaDTO) {
        Categorias categorias = categoriaMapper.map(categoriaDTO);
        categorias = categoriaRepository.save(categorias);
        return categoriaMapper.map(categorias);
    }

    // Listar
    public List<CategoriaDTO> listar () {
        List<Categorias> lista = categoriaRepository.findAll();
        return lista.stream()
                .map(categoriaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar Por id
    public CategoriaDTO listarPorId (Long id) {
        Categorias categoria = categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        return categoriaMapper.map(categoria);

    }

    // editar por id
    public CategoriaDTO editar (Long id, CategoriaDTO categoriaDTO) {
        Optional<Categorias> acharCategoria = categoriaRepository.findById(id);
        if (acharCategoria.isPresent()) {
            Categorias categoriaAtualizada = categoriaMapper.map(categoriaDTO);
            categoriaAtualizada.setId(id);
            Categorias categoriaSalva = categoriaRepository.save(categoriaAtualizada);
            return categoriaMapper.map(categoriaSalva);
        } return null;
    }

    // deletar por id
    public void deletar(Long id) {
       Categorias categoria = categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
        categoriaRepository.deleteById(id);
    }

}
