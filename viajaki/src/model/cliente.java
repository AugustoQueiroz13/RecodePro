package model;

public class cliente extends usuario{

	private int id_cliente;
	private String nome;
	private int cpf;
	private int telefone;
	
	private usuario usuarios; 
	
	public cliente() {
		
	}

	
	public cliente(int id_cliente, String nome, int cpf, int telefone, usuario usuarios) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.usuarios = usuarios;
	
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public usuario getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(usuario usuarios) {
		this.usuarios = usuarios;
	}

	
}