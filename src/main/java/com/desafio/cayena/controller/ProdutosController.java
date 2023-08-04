package com.desafio.cayena.controller;

import com.desafio.cayena.model.Produtos;
import com.desafio.cayena.repository.ProdutosRepository;
import com.desafio.cayena.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/produtos/")
public class ProdutosController {


    @Autowired
    private ProdutoService produtosService;

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping(value = "/all")
    public List<Produtos> consultaTodosProdutos() {
        return produtosRepository.findAll();
    }

    @GetMapping(value = "/consultar/{id}")
    public ResponseEntity<Produtos> consultaProduto(@PathVariable Integer id) {
        Produtos produto = produtosService.consultarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Produtos> cadastraProduto(@Valid @RequestBody Produtos produto) {
        Produtos produtoSalvo = produtosService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }


    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Produtos> atualizaProduto(@PathVariable Integer id, @Valid @RequestBody Produtos produtoAtualizado) {
        Produtos produto = produtosService.atualizarProduto(id, produtoAtualizado);
        return ResponseEntity.ok(produto);
    }

    @PatchMapping(value = "/atualizar/{id}")
    public ResponseEntity<Produtos> atualizaQuantidadeEmEstoque(@PathVariable Integer id, @RequestBody Produtos produto) {
        Integer quantityInStock = produto.getQuantityInStock();
        Produtos produtoAtualizado = produtosService.atualizarQuantidadeEmEstoque(id, quantityInStock);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<String> excluiProduto(@PathVariable Integer id) {
        produtosService.excluirProduto(id);
        return ResponseEntity.ok("Produto excluído com sucesso!");
    }

}
