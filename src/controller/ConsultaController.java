package controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;

import dao.ExameDao;
import dao.ConsultaDao;
import modelo.Exame;
import modelo.Consulta;

@ManagedBean
@ViewScoped
public class ConsultaController {
	private Consulta consulta = new Consulta();
	private Integer idExame;
	
	public Integer getIdExame() {
		return idExame;
	}
	public void setIdExame(Integer idExame) {
		this.idExame = idExame;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public void gravar() {
		System.out.println("Gravando..." + consulta);
		
		ConsultaDao dao = new ConsultaDao();
		
		try {
			Exame m = new ExameDao().listaPorId(idExame);
			consulta.setExame(m);
			
			if (consulta.getId() == null) {
				dao.adiciona(consulta);
			}else {
				dao.atualiza(consulta);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		consulta = new Consulta();
		idExame = null;
	}
	public List<Consulta> getTodosConsulta(){
		List<Consulta> lista = null;
		try {
			lista = new ConsultaDao().listaTodos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	
	public Consulta getConsulta() {
		return consulta;
	}
	public void remover(Consulta p) {
		try {
			new ConsultaDao().remove(p.getId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public void carregar(Consulta p) {
		consulta = p;
		idExame = p.getExame().getId();
	}
	public List<Exame> getTodosExame(){
		List<Exame> lista = null;
		 
		try {
			lista = new ExameDao().listaTodos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
