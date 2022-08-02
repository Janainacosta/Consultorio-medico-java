package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.PacienteDao;
import modelo.Paciente;

@ManagedBean
@ViewScoped
public class PacienteController {
	private Paciente paciente = new Paciente();

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void carregaPaciente(Paciente pacie) {
		paciente = pacie;
	}
	
	public void cadastraPaciente() {
		System.out.println("Usuário Clicou!");
		
		try {
			if(paciente.getIdPaciente() == null)
				PacienteDao.inserePacienteBanco(paciente);
			else
				PacienteDao.atualizaPacienteBanco(paciente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		paciente = new Paciente();
	}
	
	public List<Paciente> getTodosPaciente() {
		List<Paciente> listaPaciente = null;
		try {
			listaPaciente = PacienteDao.consultaTodosPaciente();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPaciente;
	}
	
	public void removePaciente(Paciente paciente) {
		try {
			PacienteDao.deletaPacienteBanco(paciente);
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
