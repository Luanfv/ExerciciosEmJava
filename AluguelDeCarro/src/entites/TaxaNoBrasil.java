package entites;

public class TaxaNoBrasil implements TaxaDoPais {

	public double taxa(double valor) {
		if(valor <= 100) {
			valor *= 0.2;
		}
		else {
			valor *= 0.15;
		}
		
		return valor;
	}

	
}
