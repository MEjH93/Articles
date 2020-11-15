package com.comtrade.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {
	private static Konekcija instanca;
	private Connection connection;
	private Konekcija() {
		ucitajDriver();
	}
	private void ucitajDriver() {
		// TODO Auto-generated method stub
		
	}
	public static Konekcija getInsatnca() {
		if(instanca == null) {
			instanca = new Konekcija();
		}
		return instanca;
	}

	public void pokreniTransakciju() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prvicas", "root","");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void potvrdiTransakciju() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void zatvoriKonekciju() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ponistiTransakciju() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return connection;
	}
	
}
