package modelo;

import java.util.Calendar;


public class Consulta {
	private Integer id;
	private String horario;
	private double valor; 
	private Calendar dtCadastro = Calendar.getInstance();
	private Exame exame;
	

	public Consulta() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getHorario() {
		return horario;
	}

	public void setHorario(String  horario) {
		this.horario = horario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", horario=" + horario + ", valor=" + valor + ", dtCadastro=" + dtCadastro
				+ "]";
	}
	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
}
