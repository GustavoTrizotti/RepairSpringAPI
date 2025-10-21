package com.prw3.conserto.controller;

import com.prw3.conserto.dto.DadosAtualizacaoConserto;
import com.prw3.conserto.dto.DadosCadastroConserto;
import com.prw3.conserto.dto.DadosDetalhamentoConserto;
import com.prw3.conserto.dto.DadosListagemConserto;
import com.prw3.conserto.model.Conserto;
import com.prw3.conserto.repository.ConsertoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid DadosCadastroConserto dados,
                                    UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping()
    public ResponseEntity<?> listarAtivos(@PageableDefault(size = 10, sort = {"dataEntrada"}) Pageable paginacao) {
        var pagina = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemConserto::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Conserto> conserto = repository.findById(id)
                .filter(Conserto::getAtivo);
        if (conserto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto.get()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        var conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        var conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}