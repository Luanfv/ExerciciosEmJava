package objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usado extends Produto {
	
	protected Date fabricacao;

	public Usado(String nome, Double preco, Date fabricacao) {
		super(nome, preco);
		this.fabricacao = fabricacao;
		
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	
	@Override
	public String entiqueta() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome + " (usado) $" + preco + " (" + formato.format(getFabricacao()) + ")\n");
		
		return sb.toString();
		
		
	}
	
}
