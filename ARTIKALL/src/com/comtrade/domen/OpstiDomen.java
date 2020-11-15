package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface OpstiDomen {
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement);
	public String vraiNazivTabele();
	public String vratiNaziveKolona();
	public String vratiVrednosti();
	public List<OpstiDomen> select(ResultSet resultSet);
	String vratiIdZaBrisanje();
	
	

}
