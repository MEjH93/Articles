package com.comtrade.sistemskaoperacija.artikal;

import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Artikal;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;

public class ArtikalAll extends OpstaSistemskOperacija{

	@Override
	public void izvrsiKOnkretnuSistemskuOperaciju(TransferKlasa object) {
		// TODO Auto-generated method stub
		
		Broker broker = new Broker();
		object.setResponse(broker.select(Artikal.kreiraj().zavrseno()));
		
	}

}
