package com.comtrade.sistemskaoperacija;

import com.comtrade.domen.TransferKlasa;
import com.comtrade.konekcija.Konekcija;

public abstract class OpstaSistemskOperacija {
	public void izvrsiSistemskuOperaciju(TransferKlasa object) {
		try {
			pokreniTransakciju();
			izvrsiKOnkretnuSistemskuOperaciju(object);
			potvrdiTransakciju();
			
		}catch (Exception e) {
			// TODO: handle exception
			ponistiTransakciju();
		}finally {
			zatvoriKonekciju();
		}
	}
	public void zatvoriKonekciju() {
		Konekcija.getInsatnca().zatvoriKonekciju();
	}
	public void ponistiTransakciju() {
		Konekcija.getInsatnca().ponistiTransakciju();
	}
	public void pokreniTransakciju() {
		Konekcija.getInsatnca().pokreniTransakciju();
	}
	public void potvrdiTransakciju() {
		Konekcija.getInsatnca().potvrdiTransakciju();
	}
	public abstract void izvrsiKOnkretnuSistemskuOperaciju(TransferKlasa object);

	

}
