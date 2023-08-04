package com.desafio.cayena.service;

import com.desafio.cayena.model.Produtos;
import com.desafio.cayena.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProdutoService {

    private static final String PRODUTO_NAO_ENCONTRADO_MSG = "Produto não encontrado com o ID: ";


    private final ProdutosRepository produtosRepository;

    public ProdutoService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public Produtos cadastrarProduto(Produtos produto) {
        produto.setDateOfCreation(LocalDateTime.now());
        return produtosRepository.save(produto);
    }

    public void excluirProduto(Integer id) {
        Produtos produto = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));
        produtosRepository.delete(produto);
    }

    public Produtos atualizarEstoqueProduto(Integer id, Integer quantityInStock) {
        Produtos produto = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));

        produto.setQuantityInStock(quantityInStock);
        produto.setDateOfTheLastUpdate(LocalDateTime.now());

        return produtosRepository.save(produto);
    }

    public Produtos atualizarProduto(Integer id, Produtos produtoAtualizado) {
        Produtos produtoExistente = produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));

        produtoExistente.setName(produtoAtualizado.getName());
        produtoExistente.setQuantityInStock(produtoAtualizado.getQuantityInStock());
        produtoExistente.setUnitPrice(produtoAtualizado.getUnitPrice());
        produtoExistente.setSupplierId(produtoAtualizado.getSupplierId());
        produtoExistente.setDateOfTheLastUpdate(LocalDateTime.now());

        return produtosRepository.save(produtoExistente);
    }

    public Produtos consultarProdutoPorId(Integer id) {
        return produtosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(PRODUTO_NAO_ENCONTRADO_MSG + id));
    }
}
