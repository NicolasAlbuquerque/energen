package com.generation.energen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatorio!")
	private String nome;
	
	@NotBlank(message = "O atributo senha é obrigatorio!")
	@Size(min = 8, message = "A senha deve ter no minimo 8 caracteres!")
	private String senha;
	
	@NotBlank(message = "O atributo cpf é obrigatorio!")
	private String cpf;
	
	@NotBlank(message = "O atributo telefone é obrigatorio!")
	private String telefone;
	
	@NotBlank(message = "O atributo usuario é obrigatorio!")
	@Email(message = "O atributo usuario deve ser um email valido!")
	private String usuario;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres!")
	private String foto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	

}
