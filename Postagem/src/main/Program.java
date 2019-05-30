package main;

import java.util.Date;
import java.util.Scanner;

import objetos.Comentario;
import objetos.Post;

public class Program {

	public static void main(String[] args) {
		
		Post postagem = null;
		Scanner sc = new Scanner(System.in);
		int escolha;
		
		do {
			System.out.printf("1-Adicionar post\n2-Dar like\n3-Comentar\n4-Visualizar post\n0-Finalizar programa\n");
			escolha = sc.nextInt();
			
			if(escolha == 1) {
				System.out.println("Informe o titulo:");
				sc.nextLine();
				String titulo = sc.nextLine();
				
				System.out.println("Informe o texto:");
				String texto = sc.nextLine();
				
				postagem = new Post(new Date(), titulo, texto );
		
			} else if(escolha == 2) {
				if(postagem != null) {
					postagem.addLike();
					
				} else {
					System.out.println("Post ainda não foi criado");
					
				}
				
			} else if(escolha == 3) {
				if(postagem != null) {
					System.out.println("Digite seu comentario:");
					sc.nextLine();
					String text = sc.nextLine();
					
					Comentario comentario = new Comentario(text, new Date());
					postagem.addComentario(comentario);
					
				} else {
					System.out.println("Post ainda não foi criado");
					
				}
				
			} else if(escolha == 4) {
				if(postagem != null) {
					System.out.println(postagem.toString());
				
				} else {
					System.out.println("Post ainda não foi criado");
					
				}
			}
			
			System.out.println();
		} while(escolha != 0);
		
		sc.close();
		
		System.out.println("Programa finalizado");
	}

}
