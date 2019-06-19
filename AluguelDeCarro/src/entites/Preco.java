package entites;

import java.util.concurrent.TimeUnit;

public class Preco {
	
	private double precoHora;
	private double precoDia;
	private Duracao datas;
	
	private TaxaDoPais taxa;

	public Preco(double precoHora, double precoDia, Duracao datas, TaxaDoPais taxa) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.datas = datas;
		this.taxa = taxa;
	}
	
	public double subTotal() {
		double valor;
		long tempo = datas.getDataVolta().getTime() - datas.getDataSaida().getTime();
		
		if(TimeUnit.HOURS.convert(tempo, TimeUnit.MILLISECONDS) > 12) {
			long dias = TimeUnit.DAYS.convert(tempo, TimeUnit.MILLISECONDS);
			valor = dias * precoDia;
			
			if((dias * 1000 * 60 * 60 * 24) < datas.getDataVolta().getTime()) {
				valor += precoDia;
			}
		}
		else {
			valor = 1;
			valor += TimeUnit.HOURS.convert(tempo, TimeUnit.MILLISECONDS) * precoHora;
		}
		
		return valor;
	}
	
	public double valorTotal() {
		double valor = subTotal();
		valor += taxa.taxa(valor);
		
		return valor;
	}

	public double getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(double precoHora) {
		this.precoHora = precoHora;
	}

	public double getPrecoDia() {
		return precoDia;
	}

	public void setPrecoDia(double precoDia) {
		this.precoDia = precoDia;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Subtotal: " + subTotal());
		sb.append("\nTaxa: " + taxa.taxa(subTotal()));
		sb.append("\nTotal: " + valorTotal());
		
		return sb.toString();
	}
	
}
