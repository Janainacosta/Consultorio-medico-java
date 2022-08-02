package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;

import modelo.Exame;
import modelo.Consulta;

public class ConsultaDao {
	
	public void adiciona(Consulta c) throws ClassNotFoundException, SQLException {
		String sql = 
			"INSERT INTO consulta (horario_consulta, valor_consulta, dtCadCliente,"
			+ "idExameConsulta) VALUES (?, ?, ?, ?)";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, c.getHorario());
		comandoSql.setDouble(2,  c.getValor());

		//converte Calendar em data no formato SQL
		java.util.Date data = c.getDtCadastro().getTime();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
		comandoSql.setDate(3, dataSql);
		
		comandoSql.setInt(4, c.getExame().getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Consulta c) throws ClassNotFoundException, SQLException {
		String sql = 
			"UPDATE consulta SET horario_consulta=?, valor_consulta=?, dtCadCliente=?,"
			+ " idExameConsulta=? WHERE id_consulta=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, c.getHorario());
		comandoSql.setDouble(2,  c.getValor());
		
		//converte Calendar em data no formato SQL
		java.util.Date data = c.getDtCadastro().getTime();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
			
		comandoSql.setDate(3, dataSql);
		comandoSql.setInt(4, c.getExame().getId());
		comandoSql.setInt(5, c.getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = 
			"DELETE FROM consulta WHERE id_consulta=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public List<Consulta> listaTodos() throws ClassNotFoundException, SQLException{
		List<Consulta> lista = new LinkedList<Consulta>();
		
		String sql = "SELECT * FROM consulta INNER JOIN exame ON "
				+ "consulta.idExameConsulta = exame.idExame";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Consulta c = new Consulta();
			c.setId(rs.getInt("id_consulta"));
			c.setHorario(rs.getString("horario_consulta"));
			c.setValor(rs.getDouble("valor_consulta"));
			
			// converte data sql em Calendar
			java.sql.Date dataSql = rs.getDate("dtCadCliente");
			java.util.Date data = new java.util.Date(dataSql.getTime());
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(data);
			c.setDtCadastro(calendario);
			
			Exame m = new Exame();
			m.setId(rs.getInt("idExame"));
			m.setNome(rs.getString("nomeExame"));
			
			c.setExame(m);
			
			lista.add(c);
		}
		
		return lista;
	}
	
	public Consulta listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM consulta WHERE id_consulta=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Consulta c = null;
		
		if (rs.next()) {
			c = new Consulta();
			c.setId(rs.getInt("id_consulta"));
			c.setHorario(rs.getString("horario_consulta"));
			c.setValor(rs.getDouble("valor_consulta"));
		}
		
		return c;
	}
}
