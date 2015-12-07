package org.IntroducirClientes.presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.IntroducirClientes.dominio.GestorClientes;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pnlIntroducirClientes extends JPanel {
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccin;
	private JLabel lblTelfono;
	private JLabel lblEmail;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField tfEmail;
	private JButton btnIntroducir;
	private JFormattedTextField ftfDNI;
	private JFormattedTextField ftfTfno;
	private JPanel pnl;
	
	private MaskFormatter formatoDNI;
	private MaskFormatter formatoTfno;

	private GestorClientes gestor;

	/**
	 * Create the panel.
	 */
	public pnlIntroducirClientes() {
		pnl=this;
		gestor=new GestorClientes();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			lblDni = new JLabel("DNI:");
			GridBagConstraints gbc_lblDni = new GridBagConstraints();
			gbc_lblDni.anchor = GridBagConstraints.EAST;
			gbc_lblDni.insets = new Insets(0, 0, 5, 5);
			gbc_lblDni.gridx = 0;
			gbc_lblDni.gridy = 0;
			add(lblDni, gbc_lblDni);
		}
		{
			try {
				formatoDNI=new MaskFormatter("########U");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ftfDNI = new JFormattedTextField(formatoDNI);
			GridBagConstraints gbc_ftfDNI = new GridBagConstraints();
			gbc_ftfDNI.insets = new Insets(0, 0, 5, 5);
			gbc_ftfDNI.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftfDNI.gridx = 1;
			gbc_ftfDNI.gridy = 0;
			add(ftfDNI, gbc_ftfDNI);
		}
		{
			lblDireccin = new JLabel("Dirección:");
			GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
			gbc_lblDireccin.anchor = GridBagConstraints.EAST;
			gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDireccin.gridx = 2;
			gbc_lblDireccin.gridy = 0;
			add(lblDireccin, gbc_lblDireccin);
		}
		{
			tfDireccion = new JTextField();
			GridBagConstraints gbc_tfDireccion = new GridBagConstraints();
			gbc_tfDireccion.insets = new Insets(0, 0, 5, 0);
			gbc_tfDireccion.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDireccion.gridx = 3;
			gbc_tfDireccion.gridy = 0;
			add(tfDireccion, gbc_tfDireccion);
			tfDireccion.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 1;
			add(lblNombre, gbc_lblNombre);
		}
		{
			tfNombre = new JTextField();
			GridBagConstraints gbc_tfNombre = new GridBagConstraints();
			gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
			gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNombre.gridx = 1;
			gbc_tfNombre.gridy = 1;
			add(tfNombre, gbc_tfNombre);
			tfNombre.setColumns(10);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
			gbc_lblTelfono.anchor = GridBagConstraints.EAST;
			gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
			gbc_lblTelfono.gridx = 2;
			gbc_lblTelfono.gridy = 1;
			add(lblTelfono, gbc_lblTelfono);
		}
		{
			try {
				formatoTfno=new MaskFormatter("'('+##')########");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ftfTfno = new JFormattedTextField(formatoTfno);
			GridBagConstraints gbc_ftfTfno = new GridBagConstraints();
			gbc_ftfTfno.insets = new Insets(0, 0, 5, 0);
			gbc_ftfTfno.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftfTfno.gridx = 3;
			gbc_ftfTfno.gridy = 1;
			add(ftfTfno, gbc_ftfTfno);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
			gbc_lblApellidos.anchor = GridBagConstraints.EAST;
			gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellidos.gridx = 0;
			gbc_lblApellidos.gridy = 2;
			add(lblApellidos, gbc_lblApellidos);
		}
		{
			tfApellidos = new JTextField();
			tfApellidos.setText("");
			GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
			gbc_tfApellidos.insets = new Insets(0, 0, 5, 5);
			gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfApellidos.gridx = 1;
			gbc_tfApellidos.gridy = 2;
			add(tfApellidos, gbc_tfApellidos);
			tfApellidos.setColumns(10);
		}
		{
			lblEmail = new JLabel("Email:");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 2;
			gbc_lblEmail.gridy = 2;
			add(lblEmail, gbc_lblEmail);
		}
		{
			tfEmail = new JTextField();
			tfEmail.setText("");
			GridBagConstraints gbc_tfEmail = new GridBagConstraints();
			gbc_tfEmail.insets = new Insets(0, 0, 5, 0);
			gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfEmail.gridx = 3;
			gbc_tfEmail.gridy = 2;
			add(tfEmail, gbc_tfEmail);
			tfEmail.setColumns(10);
		}
		{
			btnIntroducir = new JButton("Introducir");
			btnIntroducir.addActionListener(new BtnIntroducirActionListener());
			GridBagConstraints gbc_btnIntroducir = new GridBagConstraints();
			gbc_btnIntroducir.gridx = 3;
			gbc_btnIntroducir.gridy = 3;
			add(btnIntroducir, gbc_btnIntroducir);
		}

	}
	private class BtnIntroducirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tfNombre.getText().equals("") && tfApellidos.getText().equals("") && tfDireccion.getText().equals("")){
				JOptionPane.showMessageDialog(pnl, "Error", "Los campos del nombre y el precio no pueden estar vacíos",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					gestor.aniadirCliente(ftfDNI.getText(),tfNombre.getText(),tfApellidos.getText(),tfDireccion.getText(),ftfTfno.getText(),tfEmail.getText());
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(pnl, "Error", "No se pudo cargar el driver de la base de datos",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(pnl, "Error", "No se pudo conectar a la base de datos o el DNI introducido ya existía",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		}
	}
}
