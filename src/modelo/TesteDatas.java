package modelo;

import java.util.Calendar;
import java.util.Date;

public class TesteDatas {
	
	public static void main(String[] args) {
		Date hoje = new Date();
		System.out.println(hoje);
		
		// formato do banco
		java.sql.Date hojeSql = new java.sql.Date(hoje.getTime());
		System.out.println(hojeSql);
		
		// permite manipular datas
		Calendar ca = Calendar.getInstance(); // instância do dia
		System.out.println(ca);
		
		ca.set(2010, Calendar.APRIL, 10);
		System.out.println(ca.getTime());
		
		// Hoje existe a classe LocalDate que dá maior flexibilidade ao manipular datas
	}

}
