package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Paciente;


public class PacienteDao {
	public static void inserePacienteBanco(Paciente p) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO paciente(nome_paciente,cpf_paciente,telefone_paciente,endereco_paciente,email_paciente)" 
					+ "VALUES (?,?,?,?,?)";
		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setString(1, p.getNome_paciente());
		comandoSQL.setString(2, p.getCpf_paciente());
		comandoSQL.setString(3, p.getTelefone_paciente());
		comandoSQL.setString(4, p.getEndereco_paciente());
		comandoSQL.setString(5, p.getEmail_paciente());
		
		comandoSQL.execute();
		Conexao.getInstance().commit();
	}
	
	public static void deletaPacienteBanco(Paciente p) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM paciente WHERE id_paciente = ?";
		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setInt(1,p.getIdPaciente());
		comandoSQL.execute();
		Conexao.getInstance().commit();
	}
	
	public static void atualizaPacienteBanco(Paciente p) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE paciente "
				+ "SET nome_paciente = ?,"
				+ "cpf_paciente = ?, "
				+ "telefone_paciente = ?, "
				+ "endereco_paciente = ?, "
				+ "email_paciente = ?"
				+ " WHERE id_paciente = ?";
		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setString(1, p.getNome_paciente());
		comandoSQL.setString(2, p.getCpf_paciente());
		comandoSQL.setString(3, p.getTelefone_paciente());
		comandoSQL.setString(4, p.getEndereco_paciente());
		comandoSQL.setString(5, p.getEmail_paciente());
		comandoSQL.setInt(6, p.getIdPaciente());
		comandoSQL.execute();
		Conexao.getInstance().commit();
		
	}
	
	public static List<Paciente> consultaTodosPaciente() throws ClassNotFoundException, SQLException {
    	List<Paciente> listaPaciente = new LinkedList<Paciente>();
    	
    	String sql = "SELECT * FROM paciente";
    	
    	PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		ResultSet rs = comandoSQL.executeQuery();
    	
    	
    	while(rs.next()) {
    		Paciente p = new Paciente();
    		
    		p.setIdPaciente(rs.getInt("id_paciente"));
			p.setNome_paciente(rs.getString("nome_paciente"));
			p.setCpf_paciente(rs.getString("cpf_paciente"));
			p.setTelefone_paciente(rs.getString("telefone_paciente"));
			p.setEndereco_paciente(rs.getString("endereco_paciente"));
			p.setEmail_paciente(rs.getString("email_paciente"));
    		
			listaPaciente.add(p);
    	}
    	
    	return listaPaciente;
    }
	
	public static Paciente consultaPacientePorId(int id) throws SQLException, ClassNotFoundException {
    	String sql = "SELECT * FROM paciente WHERE id_paciente = ?";
    	PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setInt(1, id);
		
		ResultSet rs = comandoSQL.executeQuery();
		
		Paciente p = null;
		
		if (rs.next()) {
			p = new Paciente();
			p.setIdPaciente(rs.getInt("id_paciente"));
			p.setNome_paciente(rs.getString("nome_paciente"));
			p.setCpf_paciente(rs.getString("cpf_paciente"));
			p.setTelefone_paciente(rs.getString("telefone_paciente"));
			p.setEndereco_paciente(rs.getString("endereco_paciente"));
			p.setEmail_paciente(rs.getString("email_paciente"));
		}
		
		return p;
    }
}
