package objetos;

import java.util.Date;

public class Comentario {

	private String text;
	private Date data;

	public Comentario(String text, Date data) {
		this.text = text;
		this.data = data;
		
	}

	public Date getData() {
		return data;
		
	}
	
	public String getText() {
		return text;
		
	}

	public void setText(String text) {
		this.text = text;
		
	}
	
	
	
}
