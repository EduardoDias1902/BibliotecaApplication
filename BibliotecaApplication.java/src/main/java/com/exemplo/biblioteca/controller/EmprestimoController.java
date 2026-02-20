package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.repository.EmprestimoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoRepository repository;

    public EmprestimoController(EmprestimoRepository repository) {
        this.repository = repository;
    }

    // Registrar empréstimo
    @PostMapping
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo) {
        emprestimo.setDataEmprestimo(LocalDate.now());
        return repository.save(emprestimo);
    }

    // Listar todos
    @GetMapping
    public List<Emprestimo> listar() {
        return repository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Emprestimo buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Registrar devolução
    @PutMapping("/{id}/devolucao")
    public Emprestimo devolver(@PathVariable Long id) {

        Emprestimo emprestimo = repository.findById(id).orElse(null);

        if (emprestimo != null) {
            emprestimo.setDataDevolucao(LocalDate.now());
            return repository.save(emprestimo);
        }

        return null;
    }

    // Listar empréstimos por usuário
    @GetMapping("/usuario/{usuarioId}")
    public List<Emprestimo> listarPorUsuario(@PathVariable Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}