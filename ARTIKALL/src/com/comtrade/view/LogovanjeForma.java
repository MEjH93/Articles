package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerKI.KontrolerKi;
import com.comtrade.domen.KonstanteKI;
import com.comtrade.domen.KonstantePL;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;
import com.comtrade.view.proxy.Proxy;
import com.comtrade.view.proxy.ProxyLogin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogovanjeForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanjeForma frame = new LogovanjeForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogovanjeForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(49, 89, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(49, 169, 114, 14);
		contentPane.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(210, 86, 86, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("Logovanje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				char[]pass = pfPassword.getPassword();
				String password = String.copyValueOf(pass);
				User user2 = new User();
				user2.setUsername(username);
				user2.setPassword(password);
				//int status  = KontrolerKi.getInstanca().login(user2);
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setRequest(user2);
				transferKlasa.setKonstanteKI(KonstanteKI.USER);
				transferKlasa.setKonstantePL(KonstantePL.LOGOVANJE);
				KontrolerKi.getInstanca().execute(transferKlasa);
				Proxy proxy = new ProxyLogin();
				proxy.login((int)transferKlasa.getResponse());
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(187, 246, 112, 23);
		contentPane.add(btnNewButton);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(208, 166, 86, 20);
		contentPane.add(pfPassword);
	}
}
