package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro novoLivro) {

        Livro livro = repository.findById(id).orElse(null);

        if (livro != null) {
            livro.setTitulo(novoLivro.getTitulo());
            livro.setAutor(novoLivro.getAutor());
            livro.setAnoPublicacao(novoLivro.getAnoPublicacao());
            return repository.save(livro);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}