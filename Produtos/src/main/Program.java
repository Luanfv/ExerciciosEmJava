package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import objetos.Importado;
import objetos.Produto;
import objetos.Usado;

public class Program {

	public static void main(String []args) throws ParseException { 
		Scanner sc = new Scanner(System.in);
		
		List<Produto> produtos = new ArrayList<>();
		
		System.out.println("Informe a quantidade de produtos:");
		byte qtd = sc.nextByte();
		byte tipo;
		
		for(int i = 0; i < qtd; i++) {
			
			do {
				System.out.println("Informe o tipo de produto: 1-Normal/ 2-Importado/ 3-Usado");
				tipo = sc.nextByte();
			
			} while(tipo < 1 || tipo > 3);
			
			System.out.println("INFORMAÇÕES DO PRODUTO");
			
			System.out.printf("Informe o nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.printf("Informe o Valor: ");
			double preco = sc.nextDouble();
			
			
			if(tipo == 1) {	
				produtos.add(new Produto(nome, preco));
			
			} else if(tipo == 2) {
				System.out.printf("Informe o valor da taxa: ");
				double taxa = sc.nextDouble();
				
				produtos.add(new Importado(nome, preco, taxa));
				
			} else if(tipo == 3) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

				
				System.out.println("Data de fabricação do produto:");
				
				System.out.printf("Informe o dia: ");
				int dia = sc.nextInt();
				
				System.out.printf("Informe o mes: ");
				int mes = sc.nextInt();
				
				System.out.printf("Informe o ano: ");
				int ano = sc.nextInt();
				
				Date fabricacao = formato.parse(dia + "/" + mes + "/" + ano);
				
				produtos.add(new Usado(nome, preco, fabricacao));
				
			}
			
		}
		
		System.out.println();
		System.out.println("Produtos");
		System.out.println();
		
		for(Produto p : produtos) {
			System.out.println(p.entiqueta());
			
		}
		
		
		
		sc.close();
		
	}
	
}
