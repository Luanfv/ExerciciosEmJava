package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import enums.NivelTrabalho;
import objetos.Departamento;
import objetos.ContratoPorHora;

public class Program {

	public static void main(String []args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		NivelTrabalho nivelTrab = null;
		
		//Entrada de dados
		
		System.out.println("Informe o departamento");
		String departamento = sc.nextLine();
		
		Departamento departament = new Departamento(departamento);
		
		System.out.println("Informe o nome");
		String nome = sc.nextLine();
		
		int nivel;
		
		do {
			
			System.out.println("Informe o nivel de trabalho (1-Junior, 2-Mid level, 3-Senior)");
			nivel = sc.nextInt();
			
			if(nivel == 1) {
				nivelTrab = NivelTrabalho.JUNIOR;
				
			} else if(nivel == 2) {
				nivelTrab = NivelTrabalho.MID_LEVEL;
				
			} else if(nivel == 3) {
				nivelTrab = NivelTrabalho.SENIOR;
				
			}
		
		} while(nivel != 1 && nivel != 2 && nivel !=3);
		
		System.out.println("Informe o salario base");
		double salario = sc.nextDouble();
		
		
		
		objetos.Trabalhador funcionario = new objetos.Trabalhador(nome, nivelTrab, salario, departament);
		
		System.out.println();
		
		System.out.print("Informe a quantidade de contratos que " + funcionario.getNome() + " tera: ");
		int qtd = sc.nextInt();
		System.out.println();
		
		// LEITURA DE CONTRATOS
		
		for(int i = 1; i <= qtd ; i++) {
		
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("---------");
			System.out.println("Contrato " + i + "#");
			System.out.println();
			
			System.out.println("Informe o dia do contrato");
			int dia = sc.nextInt();
			
			System.out.println("Informe o mes do contrato");
			int mes = sc.nextInt();
			
			System.out.println("Informe o ano do contrato");
			int ano = sc.nextInt();
			
			Date data = formato.parse(dia + "/" + mes + "/" + ano);
			
			// -----------------------------
			
			System.out.println("Informe o valor por hora do contrato");
			double valor = sc.nextDouble();
			
			
			// -----------------------------
			System.out.println("Informe quantidade de horas trabalhada no contrato");
			int horas = sc.nextInt();
			
			//Adicionando contratos
			
			ContratoPorHora contrato = new ContratoPorHora(data, valor, horas);
			funcionario.addContrato(contrato);
		}
		
		System.out.println();
		System.out.println("-------------");
		System.out.println("Informe a data para pesquisar o salario de " + funcionario.getNome() + " em determinado mes");
		
		System.out.print("Informe o mes: ");
		int mes = sc.nextInt();
		
		System.out.print("Informe o ano: ");
		int ano = sc.nextInt();
		
		System.out.println();
		System.out.println("------------");
		System.out.println();
		
		//Mostrar contratos do mes e ano informado
		
		System.out.println("Funcionario: " + funcionario.getNome());
		System.out.println("Departamento: " + funcionario.getDepartamento().getDepartamento());
		System.out.printf("Salario base: %.2f \n", funcionario.getSalario());
		System.out.printf("Salario no mes e ano infromado: %.2f \n", funcionario.totalSalario(mes, ano));
		
		sc.close();
		
	}
	
}
