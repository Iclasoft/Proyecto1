package org.IntroducirProductos.presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.IntroducirProductos.dominio.GestorProducto;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pnlIntProductos extends JPanel {
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblDescripcion;
	private JTextField tfNombre;
	private JFormattedTextField ftfPrecio;
	private JTextArea taDescripcion;
	private JButton btnIntroducir;
	private JLabel label;
	private JPanel pnl;
	
	private MaskFormatter formatoPrecio;
	
	private GestorProducto gestor;

	/**
	 * Create the panel.
	 */
	public pnlIntProductos() {
		pnl=this;
		gestor=new GestorProducto();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 83, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			add(lblNombre, gbc_lblNombre);
		}
		{
			tfNombre = new JTextField();
			GridBagConstraints gbc_tfNombre = new GridBagConstraints();
			gbc_tfNombre.gridwidth = 2;
			gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
			gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNombre.gridx = 1;
			gbc_tfNombre.gridy = 0;
			add(tfNombre, gbc_tfNombre);
			tfNombre.setColumns(50);
		}
		{
			lblPrecio = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.anchor = GridBagConstraints.EAST;
			gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecio.gridx = 0;
			gbc_lblPrecio.gridy = 1;
			add(lblPrecio, gbc_lblPrecio);
		}
		{
			try {
				formatoPrecio = new MaskFormatter("######'.##");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formatoPrecio.setPlaceholderCharacter('0');
			ftfPrecio = new JFormattedTextField(formatoPrecio);
			ftfPrecio.setColumns(8);
			GridBagConstraints gbc_ftfPrecio = new GridBagConstraints();
			gbc_ftfPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftfPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_ftfPrecio.gridx = 1;
			gbc_ftfPrecio.gridy = 1;
			add(ftfPrecio, gbc_ftfPrecio);
		}
		{
			label = new JLabel("€");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 2;
			gbc_label.gridy = 1;
			add(label, gbc_label);
		}
		{
			lblDescripcion = new JLabel("Descripción:");
			GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
			gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescripcion.gridx = 0;
			gbc_lblDescripcion.gridy = 2;
			add(lblDescripcion, gbc_lblDescripcion);
		}
		{
			taDescripcion = new JTextArea();
			GridBagConstraints gbc_taDescripcion = new GridBagConstraints();
			gbc_taDescripcion.gridwidth = 2;
			gbc_taDescripcion.gridheight = 2;
			gbc_taDescripcion.insets = new Insets(0, 0, 5, 0);
			gbc_taDescripcion.fill = GridBagConstraints.BOTH;
			gbc_taDescripcion.gridx = 1;
			gbc_taDescripcion.gridy = 2;
			add(taDescripcion, gbc_taDescripcion);
		}
		{
			btnIntroducir = new JButton("Introducir");
			btnIntroducir.addActionListener(new BtnIntroducirActionListener());
			GridBagConstraints gbc_btnIntroducir = new GridBagConstraints();
			gbc_btnIntroducir.anchor = GridBagConstraints.EAST;
			gbc_btnIntroducir.gridx = 2;
			gbc_btnIntroducir.gridy = 4;
			add(btnIntroducir, gbc_btnIntroducir);
		}

	}

	private class BtnIntroducirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tfNombre.getText().equals("") && ftfPrecio.getText().equals("")){
				JOptionPane.showMessageDialog(pnl, "Error", "Los campos del nombre y el precio no pueden estar vacíos",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					gestor.aniadirProducto(tfNombre.getText(), taDescripcion.getText(), Double.parseDouble(ftfPrecio.getText()));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(pnl, "Error", "El precio no está bien introducido",JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(pnl, "Error", "No se pudo cargar el driver de la base de datos",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(pnl, "Error", "No se pudo conectar a la base de datos",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
				
		}
	}
}
