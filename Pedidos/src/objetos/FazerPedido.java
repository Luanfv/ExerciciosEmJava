package objetos;

public class FazerPedido {
	
	private int quantidade;
	private Produto produto;
	
	public FazerPedido(int quantidade, Produto produto){
		this.produto = produto;
		this.quantidade = quantidade;
		
	}
	
	public double subTotal() {
		return produto.getPreco() * quantidade;
		
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
