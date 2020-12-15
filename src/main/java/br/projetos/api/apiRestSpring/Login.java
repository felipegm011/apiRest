package br.projetos.api.apiRestSpring;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Login implements Serializable {
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "senha")
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
