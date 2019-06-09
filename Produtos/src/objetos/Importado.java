package objetos;

public class Importado extends Produto {
	
	protected double taxa;
	
	public Importado(String nome, Double preco, double taxa) {
		super(nome, preco);
		this.taxa = taxa;

	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public String entiqueta() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + " $" + preco + " " + "(Preço da taxa: " + taxa + ")\n");
		
		return sb.toString();
		
	}

}
