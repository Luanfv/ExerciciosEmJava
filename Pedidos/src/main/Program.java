package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import objetos.Cliente;
import objetos.FazerPedido;
import objetos.Pedido;
import objetos.Produto;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Pedido pedidos = new Pedido();
		
		System.out.print("Informe o nome do cliente: ");
		String nome = sc.nextLine();

		
		System.out.print("Informe o nome do e-mail: ");
		String email = sc.nextLine();

		
		System.out.println("DATA DE NASCIMENTO:");
		System.out.print("Dia: ");
		int dia = sc.nextInt();
		
		System.out.print("Mes: ");
		int mes = sc.nextInt();
		
		System.out.print("Ano: ");
		int ano = sc.nextInt();
		
		Date nascimento = formato.parse(dia + "/" + mes + "/" + ano);
	
		Cliente cliente = new Cliente(nome, email, nascimento);
		
		// ----------------------------------------------------
		
		System.out.println();
		System.out.println("PEDIDOS:");
		System.out.print("Informe a quantidade de pedidos: ");
		int qtd = sc.nextInt();
		
		for(int i = 1; i <= qtd; i++) {
			System.out.print("Informe o nome do produto: ");
			sc.nextLine();
			String produto = sc.nextLine();
			
			System.out.print("Informe o valor unitario: ");
			double preco = sc.nextDouble();
			
			System.out.print("Informe a quantidade: ");
			int quantidade = sc.nextInt();
			
			FazerPedido pedido = new FazerPedido(quantidade, new Produto(produto, preco));
			pedidos.addPedido(pedido);
			
			System.out.println();
			System.out.println("-----------");
			System.out.println();
			
		}
		
		cliente.setPedido(pedidos);
		
		System.out.println(cliente.toString());
		
	
		
		sc.close();
	}

}
