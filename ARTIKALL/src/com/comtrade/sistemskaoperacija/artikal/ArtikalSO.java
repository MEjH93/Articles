package com.comtrade.sistemskaoperacija.artikal;

import java.util.concurrent.BrokenBarrierException;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Artikal;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;

public class ArtikalSO extends OpstaSistemskOperacija{

	@Override
	public void izvrsiKOnkretnuSistemskuOperaciju(TransferKlasa object) {
		Artikal artikal = (Artikal) object.getRequest();
		Broker broker = new Broker();
		broker.save(artikal);
		
	}

}
