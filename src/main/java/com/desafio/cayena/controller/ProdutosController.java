package com.desafio.cayena.controller;

import com.desafio.cayena.model.Produtos;
import com.desafio.cayena.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastroProdutos(@RequestBody Produtos produtos) {
        produtosRepository.save(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getById(@PathVariable Integer id) {
        return produtosRepository.findById(id)
                .map (ResponseEntity::ok)
                .orElse (ResponseEntity.notFound().build());
    }

    @PutMapping("/alterar")
    public ResponseEntity<Produtos> alteraProdutos( @RequestBody Produtos produtos){
        return produtosRepository.findById(produtos.getId())
                .map(resposta -> ResponseEntity.ok().body(produtosRepository.save(produtos)))
                .orElse(ResponseEntity.notFound().build());
    }


}
