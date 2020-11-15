package com.comtrade.controlerPL;

import com.comtrade.domen.KonstantePL;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;
import com.comtrade.sistemskaoperacija.user.UserSo;

public class KontrolerBLUser implements KontrolerBL{

	@Override
	public void execute(TransferKlasa transferKlasa) {
		OpstaSistemskOperacija operacija = null;
		if(transferKlasa.getKonstantePL() == KonstantePL.LOGOVANJE) {
			operacija = new UserSo();
		}
		operacija.izvrsiSistemskuOperaciju(transferKlasa);
		
	}

}
