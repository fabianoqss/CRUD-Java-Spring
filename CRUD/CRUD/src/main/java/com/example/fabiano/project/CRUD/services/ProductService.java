package com.example.fabiano.project.CRUD.services;


import com.example.fabiano.project.CRUD.dto.ProdutoDTO;
import com.example.fabiano.project.CRUD.entities.Produto;
import com.example.fabiano.project.CRUD.repository.ProductRepository;
import com.example.fabiano.project.CRUD.services.exceptions.DatabaseException;
import com.example.fabiano.project.CRUD.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProdutoDTO findByID(Long id){
        Produto result = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não Encontrado"));
        return new ProdutoDTO(result);
    }



    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(Pageable pageable){
            Page<Produto> result = productRepository.findAll(pageable);
            return result.map(x -> new ProdutoDTO(x));
    }

    @Transactional
    public ProdutoDTO insert(ProdutoDTO dto){
        Produto produto = new Produto();
        copyDtotoEntity(dto, produto);
        produto = productRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    @Transactional
    public ProdutoDTO update(Long id, ProdutoDTO dto){
        try {
            Produto produto = productRepository.getReferenceById(id);
            copyDtotoEntity(dto, produto);
            produto = productRepository.save(produto);
            return new ProdutoDTO(produto);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Produto nao encontrado no banco de dados");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
            if(!productRepository.existsById(id)){
                throw new ResourceNotFoundException("Produto nao encontrado");
            }
            try{
                productRepository.deleteById(id);
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException("Falha de Integridade Referencial");
            }


    }


    private void copyDtotoEntity(ProdutoDTO dto , Produto produto){
        produto.setDescricao(dto.descricao());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());
        produto.setTipoProduto(dto.tipoProduto());
        produto.setValorFornercedor(dto.valorFornecedor());
    }


}
