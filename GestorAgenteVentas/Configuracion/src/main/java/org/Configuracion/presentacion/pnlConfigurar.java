package org.Configuracion.presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import org.Configuracion.dominio.GestorConfigurar;
import org.jdom.JDOMException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class pnlConfigurar extends JPanel {
	private JTextField txtDesde;
	private JTextField txtPara;
	private JPasswordField passwordField;
	private GestorConfigurar gc= new GestorConfigurar();
	/**
	 * Create the panel.
	 */
	public pnlConfigurar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlPrincipal = new JPanel();
		add(pnlPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_pnlPrincipal = new GridBagLayout();
		gbl_pnlPrincipal.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 37, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlPrincipal.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlPrincipal.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlPrincipal.setLayout(gbl_pnlPrincipal);
		
		JLabel lblNewLabel = new JLabel("Email \"Desde\" :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		pnlPrincipal.add(lblNewLabel, gbc_lblNewLabel);
		
		txtDesde = new JTextField();
		GridBagConstraints gbc_txtDesde = new GridBagConstraints();
		gbc_txtDesde.gridwidth = 5;
		gbc_txtDesde.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesde.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesde.gridx = 6;
		gbc_txtDesde.gridy = 3;
		pnlPrincipal.add(txtDesde, gbc_txtDesde);
		txtDesde.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.gridwidth = 2;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 3;
		gbc_lblContrasea.gridy = 4;
		pnlPrincipal.add(lblContrasea, gbc_lblContrasea);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 5;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 6;
		gbc_passwordField.gridy = 4;
		pnlPrincipal.add(passwordField, gbc_passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Email \"Para\" :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 6;
		pnlPrincipal.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtPara = new JTextField();
		GridBagConstraints gbc_txtPara = new GridBagConstraints();
		gbc_txtPara.gridwidth = 5;
		gbc_txtPara.insets = new Insets(0, 0, 5, 5);
		gbc_txtPara.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPara.gridx = 6;
		gbc_txtPara.gridy = 6;
		pnlPrincipal.add(txtPara, gbc_txtPara);
		txtPara.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					gc.guardarconfiguracion(txtDesde.getText(),String.copyValueOf(passwordField.getPassword()),txtPara.getText());
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cargarconfiguracion();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 4;
		gbc_btnGuardar.gridy = 8;
		pnlPrincipal.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 8;
		gbc_btnCancelar.gridy = 8;
		pnlPrincipal.add(btnCancelar, gbc_btnCancelar);

		cargarconfiguracion();
	}
	
	private void cargarconfiguracion(){
		ArrayList<String> config = null;
		try {
			config = gc.cargarconfiguracion();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtDesde.setText(config.remove(0));
		passwordField.setText(config.remove(0));
		txtPara.setText(config.remove(0));
	}

}
