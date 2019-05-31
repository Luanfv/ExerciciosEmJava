package objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Date momento;
	
	private List<FazerPedido> pedidos = new ArrayList<>();
	
	public void addPedido(FazerPedido pedido) {
		pedidos.add(pedido);
		momento = new Date();
		
	}
	
	public void removePedido(FazerPedido pedido) {
		pedidos.remove(pedido);
		
	}
	
	public double total() {
		double total = 0;
		
		for(FazerPedido pedido : pedidos) {
			total += pedido.subTotal();
			
		}
		
		return total;
		
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public List<FazerPedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<FazerPedido> pedidos) {
		this.pedidos = pedidos;
	}


}
