package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entites.Duracao;
import entites.Preco;
import entites.TaxaNoBrasil;
import exception.DatasExecption;

public class Program {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		try {
			System.out.println("Informe a data em que o carro foi alugado: (dd/MM/yyyy HH:mm)");
			Date saida = formato.parse(sc.nextLine());
			
			System.out.println("Informe a data em que o carro foi devolvido: (dd/MM/yyyy HH:mm)");
			Date volta = formato.parse(sc.nextLine());
			
			System.out.println("Informe o valor por hora: ");
			double hora = sc.nextDouble();
			
			System.out.println("Informe o valor por dia: ");
			double dia = sc.nextDouble();
			
			Preco preco = new Preco(hora, dia, new Duracao(saida, volta), new TaxaNoBrasil());
			
			System.out.println(preco.toString());
		}
		catch (ParseException e) {
			System.out.println("Erro: Data informada de forma incorreta");
		}
		catch (InputMismatchException e) {
			System.out.println("Erro: Informação inserida não confere com o tipo da pedida");
		}
		catch(DatasExecption e) {
			System.out.println(e.toString());
		}
		catch (RuntimeException e) {
			System.out.println("Erro: Não indentificado");
		}
		finally {
			sc.close();
		}
	}
}
