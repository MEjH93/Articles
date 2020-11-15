package com.comtrade.controlerKI;

import java.util.List;

import com.comtrade.controlerPL.KontrolerBL;
import com.comtrade.controlerPL.KontrolerBLArtikal;
import com.comtrade.controlerPL.KontrolerBLUser;
import com.comtrade.domen.Artikal;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;

public class KontrolerKi {
	private static KontrolerKi instanca;
	private KontrolerKi() {
		
	}
	
	public static KontrolerKi getInstanca() {
		if (instanca == null) {
			instanca = new KontrolerKi();
		}
		return instanca;
	}
	
	public void execute(TransferKlasa transferKlasa) {
		KontrolerBL kontrolerBL = null;
		switch (transferKlasa.getKonstanteKI()) {
		case USER:
			kontrolerBL = new KontrolerBLUser();
			break;
		case ARTIKAL:
			kontrolerBL = new KontrolerBLArtikal();
			break;

		default:
			break;
		}
		kontrolerBL.execute(transferKlasa);
	}
	
}
