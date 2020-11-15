package com.comtrade.broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.comtrade.domen.Artikal;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.domen.OpstiDomenDecorator;
import com.comtrade.domen.User;
import com.comtrade.konekcija.Konekcija;

public class Broker {
	public int vratiUsera(OpstiDomenDecorator user) {
		
		return user.vratiUsera();
		
	}
	public void save(OpstiDomen opstiDomen) {
		String sql = "INSERT INTO "+opstiDomen.vraiNazivTabele()+""+opstiDomen.vratiNaziveKolona()+" VALUES"+
				opstiDomen.vratiVrednosti();
	try {
		PreparedStatement preparedStatement = Konekcija.getInsatnca().getConnection().prepareStatement(sql);
		preparedStatement = opstiDomen.sacuvaj(preparedStatement);
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	public List<OpstiDomen>select(OpstiDomen opstiDomen){
		String sql ="select * from "+opstiDomen.vraiNazivTabele();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = Konekcija.getInsatnca().getConnection().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return opstiDomen.select(resultSet);
		
	}
	public void obrisi(int id, OpstiDomen opstiDomen) {
		String sql ="delete from "+opstiDomen.vraiNazivTabele()+" where "+opstiDomen.vratiIdZaBrisanje()  +" = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInsatnca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void dodaj(Artikal artikal, OpstiDomen opstiDomen) {
		String sql = "INSERT INTO "+opstiDomen.vraiNazivTabele()+""+opstiDomen.vratiNaziveKolona()+" VALUES"+
				opstiDomen.vratiVrednosti();
	try {
		PreparedStatement preparedStatement = Konekcija.getInsatnca().getConnection().prepareStatement(sql);
		preparedStatement = opstiDomen.sacuvaj(preparedStatement);
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		
		
	}
	
	
	

