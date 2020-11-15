package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator.OfPrimitive;

public class Artikal implements OpstiDomen{
	private final int id;
	private final String naziv;
	private final String barKod;
	private final int cena;
	public Artikal(ArtikalBuilder artikal) {
		id = artikal.id;
		naziv = artikal.naziv;
		barKod = artikal.barKod;
		cena = artikal.cena;
	}
	
	
	public int getId() {
		return id;
	}


	public String getNaziv() {
		return naziv;
	}


	public String getBarKod() {
		return barKod;
	}


	public int getCena() {
		return cena;
	}


	public static ArtikalBuilder kreiraj() {
		return new ArtikalBuilder();
	}
	public static class ArtikalBuilder{
		private int id;
		private String naziv;
		private String barKod;
		private int cena;
		public ArtikalBuilder() {
			
		}
		public ArtikalBuilder setId(int id) {
			this.id = id;
			return  this;
			
		}
		public ArtikalBuilder setNaziv(String naziv) {
			this.naziv = naziv;
			return  this;
			
		}
		public ArtikalBuilder setBArkoD(String barKod) {
			this.barKod = barKod;
			return  this;
			
		}
		public ArtikalBuilder setCena(int cena) {
			this.cena = cena;
			return  this;
			
		}
		public  Artikal zavrseno() {
			return new Artikal(this);
		}
	}

	@Override
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1,naziv);
			preparedStatement.setString(2, barKod);
			preparedStatement.setInt(3,cena);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return preparedStatement;
	}

	@Override
	public String vraiNazivTabele() {
		// TODO Auto-generated method stub
		return "artikal";
	}

	@Override
	public String vratiNaziveKolona() {
		// TODO Auto-generated method stub
		return "(`naziv_artikla`, `bar_kod`, `cena`)";
	}

	@Override
	public String vratiVrednosti() {
		// TODO Auto-generated method stub
		return "(?,?,?)";
	}


	@Override
	public List<OpstiDomen> select(ResultSet resultSet) {
		// TODO Auto-generated method stub
		List<OpstiDomen>list = new ArrayList<OpstiDomen>();
		try {
			while(resultSet.next()) {
				
					Artikal artikal = Artikal.kreiraj()
							.setId(resultSet.getInt("id_artikal"))
							.setBArkoD(resultSet.getString("bar_kod"))
							.setNaziv(resultSet.getString("naziv_artikla"))
							.setCena(resultSet.getInt("cena"))
							.zavrseno();
					list.add(artikal);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public String vratiIdZaBrisanje() {
		// TODO Auto-generated method stub
		return "id_artikal";
	}


	
	

}
