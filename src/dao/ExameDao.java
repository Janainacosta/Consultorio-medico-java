package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Exame;

public class ExameDao {
	
	public List<Exame> listaTodos() throws ClassNotFoundException, SQLException{
		List<Exame> lista = new LinkedList<Exame>();
		
		String sql = "SELECT * FROM exame";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Exame t = new Exame();
			t.setId(rs.getInt("idExame"));
			t.setNome(rs.getNString("nomeExame"));
			
			lista.add(t);
		}
		
		return lista;
	}
	
	public Exame listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM exame WHERE idExame=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Exame t = null;
		
		if (rs.next()) {
			t = new Exame();
			t.setId(rs.getInt("idExame"));
			t.setNome(rs.getString("nomeExame"));
		}
		
		return t;
	}

}
