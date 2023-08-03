package com.desafio.cayena.controller;

import com.desafio.cayena.model.Produtos;
import com.desafio.cayena.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

}
