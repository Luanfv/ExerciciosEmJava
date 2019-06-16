package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import entites.Conta;
import exception.DepositarExecption;
import exception.SaqueExecption;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**INFORME OS DADOS DA CONTA**");
		System.out.println();
		
		try {
			
			System.out.println("Informe o numero da conta: ");
			int numero = sc.nextInt();
			
			System.out.println("Informe o nome do dono da conta: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.println("Informe o saldo incial: ");
			double saldo = sc.nextDouble();
			
			System.out.println("Informe o limite de saque: ");
			double saqueLimite = sc.nextDouble();
			
			Conta conta = new Conta(numero, nome, saldo, saqueLimite);
			
			System.out.println();
			
			System.out.println("Informe o valor de deposito: ");
			double deposito = sc.nextDouble();
			
			conta.depositar(deposito);
			
			System.out.println();
			
			System.out.println("Informe o valor de saque: ");
			double saque = sc.nextDouble();
			
			conta.saque(saque);
			
			System.out.println();
			
			System.out.println(conta.toString());
		
		} 
		catch (InputMismatchException e) {
			System.out.println("Erro: Valor informado não confere com o pedido");
			
		}
		catch (SaqueExecption e) {
			System.out.println("Erro: " + e.getMessage());
			
		}
		catch (DepositarExecption e) {
			System.out.println("Erro: " + e.getMessage());
			
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
			
		}
		finally {
			sc.close();
			
		}
		
			
	}

}
