package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.comtrade.konekcija.Konekcija;

public class User implements  OpstiDomenDecorator{
	private int id;
	private String username;
	private String password;
	private String ime;
	private int status;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3,ime);
			preparedStatement.setInt(4, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	@Override
	public String vraiNazivTabele() {
		// TODO Auto-generated method stub
		return "korisnik";
	}
	@Override
	public String vratiNaziveKolona() {
		// TODO Auto-generated method stub
		return "( username, password, ime, status)";
	}
	@Override
	public String vratiVrednosti() {
		// TODO Auto-generated method stub
		return "(?,?,?,?)";
	}
	@Override
	public int vratiUsera() {
		// TODO Auto-generated method stub
		String sql = "select * from korisnik  where username = ? and password  = ?";
		int status = -1;
		try {
			PreparedStatement preparedStatement = Konekcija.getInsatnca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.first()) {
				status = resultSet.getInt("status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public List<OpstiDomen> select(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String vratiIdZaBrisanje() {
		// TODO Auto-generated method stub
		return "id_usera";
	}
	
	

}
