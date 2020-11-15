package com.comtrade.sistemskaoperacija.artikal;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Artikal;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;

public class ArtikalObrisi extends OpstaSistemskOperacija{

	@Override
	public void izvrsiKOnkretnuSistemskuOperaciju(TransferKlasa object) {
		int idArtikal = (int) object.getRequest();
		Broker broker = new Broker();
		broker.obrisi(idArtikal, Artikal.kreiraj().zavrseno());
		
	}

}
