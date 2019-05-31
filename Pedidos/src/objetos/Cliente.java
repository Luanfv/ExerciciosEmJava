package objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private String nome;
	private String email;
	private Date nascimento;
	
	private Pedido pedido;

	public Cliente(String nome, String email, Date nascimento) {
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public Pedido getPedido() {
		return pedido;
		
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
		
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat nc = new SimpleDateFormat("dd/MM/yyyy");
		
		sb.append("INFROMAÇÕES DOS PEDIDOS:\n");
		sb.append("Momento que foi realizado os pedidos: " + formato.format(getPedido().getMomento()) + "\n");
		sb.append("Cliente: " + nome + " (" + nc.format(nascimento) + ") - " + email + "\n");
		for(FazerPedido p : pedido.getPedidos()) {
			sb.append(p.getProduto().getNome() + ", $" + p.getProduto().getPreco() + ", quantidade: " + p.getQuantidade() + ", SubTotal: " + p.subTotal() + "\n");
		
		}
		sb.append("Total: $" +getPedido().total());
		
		return sb.toString();
	}

}
