package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerKI.KontrolerKi;
import com.comtrade.domen.Artikal;
import com.comtrade.domen.KonstanteKI;
import com.comtrade.domen.KonstantePL;
import com.comtrade.domen.TransferKlasa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ArtikalForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfCena;
	private JTextField tfNaziv;
	private JTextField tfBarkod;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	int id_Artikal;

	
	public ArtikalForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cena");
		lblNewLabel.setBounds(70, 58, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Naziv");
		lblNewLabel_1.setBounds(70, 134, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfCena = new JTextField();
		tfCena.setBounds(159, 55, 86, 20);
		contentPane.add(tfCena);
		tfCena.setColumns(10);
		
		tfNaziv = new JTextField();
		tfNaziv.setColumns(10);
		tfNaziv.setBounds(159, 131, 86, 20);
		contentPane.add(tfNaziv);
		
		JLabel lblBarkod = new JLabel("Barkod");
		lblBarkod.setBounds(70, 205, 46, 14);
		contentPane.add(lblBarkod);
		
		tfBarkod = new JTextField();
		tfBarkod.setColumns(10);
		tfBarkod.setBounds(159, 202, 86, 20);
		contentPane.add(tfBarkod);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String naziv = tfNaziv.getText();
				String cena = tfCena.getText();
				String barkod = tfBarkod.getText();
				Artikal artikal = Artikal.kreiraj()
						.setNaziv(naziv)
						.setCena(Integer.parseInt(cena))
						.setBArkoD(barkod)
						.zavrseno();
				//KontrolerKi.getInstanca().upisiArtikal(artikal);
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setRequest(artikal);
				transferKlasa.setKonstanteKI(KonstanteKI.ARTIKAL);
				transferKlasa.setKonstantePL(KonstantePL.DODAJ_ARTIKAL);
				KontrolerKi.getInstanca().execute(transferKlasa);
				postaviPodatke();
						
				
			}
		});
		btnNewButton.setBounds(156, 233, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 282, 366, 101);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int red = table.getSelectedRow();
				id_Artikal = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setRequest(id_Artikal);
				transferKlasa.setKonstanteKI(KonstanteKI.ARTIKAL);
				transferKlasa.setKonstantePL(KonstantePL.OBRISI_ARTIKAL);
				KontrolerKi.getInstanca().execute(transferKlasa);
				postaviPodatke();
			}
		});
		btnNewButton_1.setBounds(273, 233, 89, 23);
		contentPane.add(btnNewButton_1);
		Object []kolone= {"Id","Naziv","BarKod","Cena"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		postaviPodatke();
	}

	private void postaviPodatke() {
		// TODO Auto-generated method stub
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKonstanteKI(KonstanteKI.ARTIKAL);
		transferKlasa.setKonstantePL(KonstantePL.VRATI_ARTIKLE);
		KontrolerKi.getInstanca().execute(transferKlasa);
		dtm.setRowCount(0);
		for(Artikal artikal : (List<Artikal>)transferKlasa.getResponse()) {
			Object[]red = {artikal.getId(), artikal.getNaziv(),artikal.getBarKod(), artikal.getCena()};
			dtm.addRow(red);
		}
		
	}
}
