package entites;

import java.util.Date;

import exception.DatasExecption;

public class Duracao {
	
	private Date dataSaida;
	private Date dataVolta;
	
	public Duracao(Date dataSaida, Date dataVolta) throws DatasExecption {
		
		if(dataSaida.getTime() > dataVolta.getTime()) {
			throw new DatasExecption("Erro: Data de saida não pode ser menor que a de volta");
		}
		
		this.dataSaida = dataSaida;
		this.dataVolta = dataVolta;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

}
