package com.comtrade.view.proxy;

import javax.swing.JOptionPane;

import com.comtrade.view.MedjuForma;

public class ProxyLogin implements Proxy {

	@Override
	public int login(int status) {
		if(status == 1) {
			MedjuForma medjuForma = new MedjuForma();
			medjuForma.setVisible(true);
		}else if(status == 0) {
			
		}else {
			JOptionPane.showMessageDialog(null, "Ne postojis!!!");
		}
		
		return 0;
	}

}
