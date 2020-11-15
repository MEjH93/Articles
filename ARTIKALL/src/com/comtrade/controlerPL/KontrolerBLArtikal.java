package com.comtrade.controlerPL;

import com.comtrade.domen.KonstantePL;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;
import com.comtrade.sistemskaoperacija.artikal.ArtikalAll;
import com.comtrade.sistemskaoperacija.artikal.ArtikalDodaj;
import com.comtrade.sistemskaoperacija.artikal.ArtikalObrisi;
import com.comtrade.sistemskaoperacija.user.UserSo;
import com.comtrade.view.ArtikalForma;

public class KontrolerBLArtikal implements KontrolerBL{

	@Override
	public void execute(TransferKlasa transferKlasa) {
		OpstaSistemskOperacija operacija = null;
		if(transferKlasa.getKonstantePL() == KonstantePL.VRATI_ARTIKLE) {
			operacija = new ArtikalAll();
		}else if(transferKlasa.getKonstantePL() == KonstantePL.OBRISI_ARTIKAL) {
			operacija = new ArtikalObrisi();
		}else if(transferKlasa.getKonstantePL() == KonstantePL.DODAJ_ARTIKAL) {
			operacija = new ArtikalDodaj();
		}
		operacija.izvrsiSistemskuOperaciju(transferKlasa);
		
	}

}
