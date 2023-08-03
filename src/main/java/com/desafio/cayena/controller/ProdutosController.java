package com.desafio.cayena.controller;

import com.desafio.cayena.model.Produtos;
import com.desafio.cayena.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos/")
public class ProdutosController {

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping(value = "/all")
    public List<Produtos> consultaProdutos() {
        return produtosRepository.findAll();
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Produtos> cadastroProduto(@RequestBody Produtos produtos) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtosRepository.save(produtos));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getById(@PathVariable Integer id) {
        return produtosRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/alterar")
    public ResponseEntity<Produtos> alteraProduto(@RequestBody Produtos produtos) {
        return produtosRepository.findById(produtos.getId())
                .map(resposta -> ResponseEntity.ok().body(produtosRepository.save(produtos)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Integer id) {
        try {
            produtosRepository.deleteById(id);
            return ResponseEntity.ok("Produto deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
