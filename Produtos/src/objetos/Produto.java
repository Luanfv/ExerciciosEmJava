package objetos;

public class Produto {

	protected String nome;
	protected double preco;
	
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String entiqueta() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + " $" + preco + "\n");
		
		return sb.toString();
		
	}
	
}
