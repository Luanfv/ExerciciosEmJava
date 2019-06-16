package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exception.Execao;

public class Check {
	
	private int numQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public Check(int numQuarto, Date checkin, Date checkout) throws Execao {
		//Se a data de check-in for maior que check-out cai nessa exeção
		if(checkin.getTime() > checkout.getTime()) {
			throw new Execao("Erro: Data do check-out maior que de check-in");
			
		}
		
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long QuantidadeDeNoites() {
		long dias = checkout.getTime() - checkin.getTime();
		
		//converte milissegundos em dias
		return TimeUnit.DAYS.convert(dias, TimeUnit.MILLISECONDS);
		
	}
	
	public void updaDates(Date checkin, Date checkout) throws Execao {
		
		//Se a data de novo checkin for menor que atual checkin cai nessa exeção
		if(checkin.getTime() < this.checkin.getTime()) {
			throw new Execao("Erro: O update do check-in tem que ser maior ou igual ao atual check-in");
		
		}
		//Se a data de check-in for maior que check-out cai nessa exeção
		if(checkin.getTime() > checkout.getTime()) {
			throw new Execao("Erro: Data do check-out maior que de check-in");
			
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	@Override
	public String toString() {
		String msg = "Hospede do quarto " + getNumQuarto() + " ficou " + QuantidadeDeNoites() + " noites. Check-in: " + formato.format(getCheckin()) + ", Check-out: " + formato.format(getCheckout());
		
		return msg;
		
	}

}
