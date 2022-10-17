package model;

public class pedido {

	private String destino;
	private int data_viagem;
	private int qtde_dias;
	private int qtde_passagem;
	private String hotel;
	private int id_cliente;
	
	private cliente cliente;
	
	public pedido() {
		
	}

	public pedido(String destino, int data_viagem, int qtde_dias, int qtde_passagem, String hotel, int id_cliente,
			model.cliente cliente) {
		this.destino = destino;
		this.data_viagem = data_viagem;
		this.qtde_dias = qtde_dias;
		this.qtde_passagem = qtde_passagem;
		this.hotel = hotel;
		this.id_cliente = id_cliente;
		this.cliente = cliente;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getData_viagem() {
		return data_viagem;
	}

	public void setData_viagem(int data_viagem) {
		this.data_viagem = data_viagem;
	}

	public int getQtde_dias() {
		return qtde_dias;
	}

	public void setQtde_dias(int qtde_dias) {
		this.qtde_dias = qtde_dias;
	}

	public int getQtde_passagem() {
		return qtde_passagem;
	}

	public void setQtde_passagem(int qtde_passagem) {
		this.qtde_passagem = qtde_passagem;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	
}
