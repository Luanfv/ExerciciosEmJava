package objetos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private Date data;
	private String titulo;
	private String texto;
	private int like = 0;
	
	private List<Comentario> comentarios = new ArrayList<>();

	public Post(Date data, String titulo, String texto) {
		this.data = data;
		this.titulo = titulo;
		this.texto = texto;
		
	}
	
	public void addComentario(Comentario comentario) {
		comentarios.add(comentario);
		
	}
	
	public void removeComentario(Comentario comentario) {
		comentarios.remove(comentario);
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void addLike() {
		this.like += 1;
		
	}
	
	public void removeLike() {
		this.like -= 1;
		
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		
		//StringBuilder adiciona Strings no final
		
		sb.append("\nPOSTAGEM\n-----------\n");
		sb.append(titulo + "\n");
		sb.append(formato.format(data) + "\n\n");
		sb.append(texto + "\n");
		sb.append("Likes: " + like + "\n");
		sb.append("\nCOMENTARIOS");
		
		for(Comentario comentario : comentarios) {
			sb.append("\n--------------\n");
			sb.append(formato.format(comentario.getData()) + "\n\n");
			sb.append(comentario.getText());
		}
		
		sb.append("\n--------------\n");
		
		return sb.toString();
	}

}
