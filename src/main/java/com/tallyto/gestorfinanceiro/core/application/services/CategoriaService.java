package com.tallyto.gestorfinanceiro.core.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tallyto.gestorfinanceiro.core.domain.entities.Categoria;
import com.tallyto.gestorfinanceiro.core.infra.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarCategoriaPorNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

    public Categoria buscaCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public void excluirCategoria(Long id) {
        // Verifica se a categoria existe antes de tentar excluir
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada com ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        Categoria categoriaExistente = buscaCategoriaPorId(id);
        categoriaExistente.setNome(categoria.getNome());
        return categoriaRepository.save(categoriaExistente);
    }
}