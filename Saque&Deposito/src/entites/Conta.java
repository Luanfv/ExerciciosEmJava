package entites;

import exception.DepositarExecption;
import exception.SaqueExecption;

public class Conta {
	
	private int numero;
	private String nome;
	private double saldo;
	private double saqueLimite;
	
	public Conta(int numero, String nome, double saldo, double saqueLimite) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.saqueLimite = saqueLimite;
		
	}
	
	public void depositar(double saldo) throws DepositarExecption {
		if(saldo < 0) {
			throw new DepositarExecption("O valor de deposito tem que ser maior que 0");
			
		}
		
		this.saldo += saldo;
		
	}
	
	public void saque(double saque) throws SaqueExecption {
		if(saque > saqueLimite) {
			throw new SaqueExecption("Valor informado ultrapassou o limite de saque");
			
		}
		if(saque > saldo) {
			throw new SaqueExecption("Valor informado ultrapassou o saldo");
			
		}
		
		saldo -= saque;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaqueLimite() {
		return saqueLimite;
	}

	public void setSaqueLimite(double saqueLimite) {
		this.saqueLimite = saqueLimite;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("**INFORMAÇÕES DA CONTA**\n\n");
		sb.append("Numero: " + getNumero() + "\n");
		sb.append("Nome: " + getNome() + "\n");
		sb.append("Saldo: R$ " + getSaldo() + "\n");
		sb.append("Limite de saque: R$ " +getSaqueLimite() + "\n");
		
		return sb.toString();
		
	}

}
