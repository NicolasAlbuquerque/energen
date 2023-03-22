package com.generation.energen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 50 , message = "O Atributo nome_produto é obrigatório")
    private String nome_produto;
    @NotBlank
    @Size(min = 1, max = 50 , message = "O Atributo marca é obrigatório")
    private String marca;
    @NotBlank
    @Size(min = 5, max = 1000, message = "O Atributo descrição é obrigatório.")
    private String descricao;
    @NotNull(message = "O atributo preço é obrigatório.")
    private Double preco;
    @NotNull(message = "O atributo qtd_estoque é obrigatório.")
    private Integer qtd_estoque;
    @NotBlank(message = "O atributo foto é obrigatório.")
    private String foto;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(Integer qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    
}
