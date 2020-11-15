package com.comtrade.sistemskaoperacija.artikal;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Artikal;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;

public class ArtikalDodaj extends OpstaSistemskOperacija{

	@Override
	public void izvrsiKOnkretnuSistemskuOperaciju(TransferKlasa object) {
		Artikal artikal = (Artikal) object.getRequest();
		Broker broker = new Broker();
		broker.dodaj(artikal, Artikal.kreiraj().zavrseno());
		
	}

}