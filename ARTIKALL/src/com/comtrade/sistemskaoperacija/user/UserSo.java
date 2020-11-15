package com.comtrade.sistemskaoperacija.user;

import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;
import com.comtrade.sistemskaoperacija.OpstaSistemskOperacija;

public class UserSo extends OpstaSistemskOperacija{

	@Override
	public void izvrsiKOnkretnuSistemskuOperaciju(TransferKlasa object) {
		User user = (User) object.getRequest();
		Broker broker = new Broker();
		Integer status  = broker.vratiUsera(user);
		user.setStatus(status);
		object.setResponse(status);
		
	}

}
