package model;

import java.time.LocalDate;

public class Cliente {
	
	private int id;
	private String nome;
	private String login;
	private String senha;
	private LocalDate dataNasc;	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}	
	
	public Cliente() {
		super();
	}
	public Cliente(int id, String nome, String login, String senha, LocalDate dataNasc) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataNasc = dataNasc;
	}
	
}
