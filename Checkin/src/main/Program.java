package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import entities.Check;
import exception.Execao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.println("**ADICIONANDO CHECKIN**");
			System.out.println();
			
			System.out.print("Informe o numero do quarto: ");
			int numQuarto = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Informe o Check-in (dd/MM/yyyy): ");
			Date checkin = formato.parse(sc.nextLine());
			
			System.out.print("Informe o Check-out (dd/MM/yyyy): ");
			Date checkout = formato.parse(sc.nextLine());
			
			Check check = new Check(numQuarto, checkin, checkout);
			
			System.out.println(check.toString());
		
			System.out.println();
			System.out.println("**UPDATE NO CHECKIN**");
			System.out.println();
			
			System.out.print("Informe o Check-in (dd/MM/yyyy): ");
			checkin = formato.parse(sc.nextLine());
			
			System.out.print("Informe o Check-out (dd/MM/yyyy): ");
			checkout = formato.parse(sc.nextLine());
			
			check.updaDates(checkin, checkout);
			
			System.out.println(check.toString());
			
		}
		//Ativa se der erro na conversão da data
		catch(ParseException e) {
			System.out.println("Erro: Data inválida");
			System.out.println(e.toString());
			
		}
		//Ativa se der algum erro na entrada de dados (por uma string quando tiver lendo inteiros por exemplo)
		catch(InputMismatchException e) {
			System.out.println("Erro: Informação passada não é a que foi pedida");
			System.out.println(e.toString());
			
		}
		//Exeção criada/personalizada
		//Ativa atraves da class Check (caso a check-in for maior que check-out por exemplo) 
		catch(Execao e) {
			System.out.println(e.getMessage());
			
		}
		//Trata qualquer tipo de erro durante (sem precisar saber qual é)
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		//Independente se deu algum erro ou não as execuções dentro do "finally" é executada
		finally {
			sc.close();
		}
	}

}
