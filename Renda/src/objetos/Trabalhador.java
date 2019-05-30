package objetos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import objetos.ContratoPorHora;

import enums.NivelTrabalho;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalho nivel;
	private double salario;
	
	private List<ContratoPorHora> contratos = new ArrayList<>();
	private Departamento departamento;
	
	public Trabalhador(String nome, NivelTrabalho nivel, double salario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.departamento = departamento;
		
	}
	
	public void addContrato(ContratoPorHora contrato) {
		this.contratos.add(contrato);
		
	}
	
	public void removeContrato(ContratoPorHora contrato) {
		this.contratos.remove(contrato);
		
	}
	
	public double totalSalario(int mes, int ano) {
		double salarioMes = salario;
		Calendar cal = Calendar.getInstance();	
		
		for(ContratoPorHora contrato : contratos) {
			cal.setTime(contrato.getData());
			
			int anoContrato = cal.get(Calendar.YEAR);
			int mesContrato = cal.get(Calendar.MONTH) + 1;
			
			if(ano == anoContrato && mes == mesContrato) {
				salarioMes += contrato.valorTotal();
			}
		}
		
		return salarioMes;
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public NivelTrabalho getNivel() {
		return nivel;
	}
	
	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Trabalhador [nome=" + nome + ", nivel=" + nivel + ", salario=" + salario + ", departamento="
				+ departamento.getDepartamento() + "]";
	}
	
	

}
