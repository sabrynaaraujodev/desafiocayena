package com.desafio.cayena.controller;

import com.desafio.cayena.model.Produtos;
import com.desafio.cayena.repository.ProdutosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/produtos/")
public class ProdutosController {

    private static final String PRODUTO_NAO_ENCONTRADO_MSG = "Produto não encontrado com o ID: ";

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping(value = "/all")
    public List<Produtos> consultaTodosProdutos() {
        return produtosRepository.findAll();
    }

    @GetMapping(value = "/consultar/{id}")
    public ResponseEntity<Produtos> consultaProduto(@PathVariable Integer id) {
        Produtos produto = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));
        return ResponseEntity.ok(produto);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Produtos> cadastraProduto(@Valid @RequestBody Produtos produto) {
        produto.setDateOfCreation(LocalDateTime.now());
        Produtos produtoSalvo = produtosRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Produtos> atualizaProduto(@PathVariable Integer id, @Valid @RequestBody Produtos produtoAtualizado) {
        Produtos produtoExistente = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));
        BeanUtils.copyProperties(produtoAtualizado, produtoExistente, "id");
        Produtos produtoSalvo = produtosRepository.save(produtoExistente);
        return ResponseEntity.ok(produtoSalvo);
    }

    @PatchMapping(value = "/atualizar/{id}")
    public ResponseEntity<Produtos> atualizaQuantidadeEmEstoque(@PathVariable Integer id, @RequestBody Produtos produtoAtualizado) {
        Produtos produtoExistente = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));
        produtoExistente.setQuantityInStock(produtoAtualizado.getQuantityInStock());
        produtoExistente.setDateOfTheLastUpdate(LocalDateTime.now());
        Produtos produtoSalvo = produtosRepository.save(produtoExistente);
        return ResponseEntity.ok(produtoSalvo);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<String> excluiProduto(@PathVariable Integer id) {
        Produtos produto = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));
        produtosRepository.delete(produto);
        return ResponseEntity.ok("Produto excluído com sucesso!");
    }

}
