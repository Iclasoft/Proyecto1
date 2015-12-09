package org.VisualizarProducto.presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;

import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class pnlVisualizarProducto extends JPanel {
	@SuppressWarnings("rawtypes")
	private JList list;
	private JLabel lblIdProducto;
	private JLabel lblNombre;
	private JLabel lblDescripcin;
	private JLabel lblPrecio;
	private JLabel lblDisponible;
	private JTextField txtIdProducto;
	private JTextField textNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public pnlVisualizarProducto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{174, 0, 0, 60, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			list = new JList();
			list.addListSelectionListener(new ListListSelectionListener());
			list.setBorder(new TitledBorder(null, "ListaProductos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.gridheight = 4;
			gbc_list.insets = new Insets(0, 0, 5, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 0;
			gbc_list.gridy = 0;
			add(list, gbc_list);
		}
		{
			lblIdProducto = new JLabel("Producto:");
			GridBagConstraints gbc_lblIdProducto = new GridBagConstraints();
			gbc_lblIdProducto.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lblIdProducto.insets = new Insets(0, 0, 5, 5);
			gbc_lblIdProducto.gridx = 3;
			gbc_lblIdProducto.gridy = 0;
			add(lblIdProducto, gbc_lblIdProducto);
		}
		{
			txtIdProducto = new JTextField();
			txtIdProducto.setEnabled(false);
			GridBagConstraints gbc_txtIdProducto = new GridBagConstraints();
			gbc_txtIdProducto.anchor = GridBagConstraints.SOUTH;
			gbc_txtIdProducto.insets = new Insets(0, 0, 5, 0);
			gbc_txtIdProducto.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIdProducto.gridx = 4;
			gbc_txtIdProducto.gridy = 0;
			add(txtIdProducto, gbc_txtIdProducto);
			txtIdProducto.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.WEST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 3;
			gbc_lblNombre.gridy = 1;
			add(lblNombre, gbc_lblNombre);
		}
		{
			textNombre = new JTextField();
			GridBagConstraints gbc_textNombre = new GridBagConstraints();
			gbc_textNombre.insets = new Insets(0, 0, 5, 0);
			gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textNombre.gridx = 4;
			gbc_textNombre.gridy = 1;
			add(textNombre, gbc_textNombre);
			textNombre.setColumns(10);
		}
		{
			lblDescripcin = new JLabel("Descripción:");
			GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
			gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
			gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescripcin.gridx = 3;
			gbc_lblDescripcin.gridy = 2;
			add(lblDescripcin, gbc_lblDescripcin);
		}
		{
			txtDescripcion = new JTextField();
			GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
			gbc_txtDescripcion.insets = new Insets(0, 0, 5, 0);
			gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDescripcion.gridx = 4;
			gbc_txtDescripcion.gridy = 2;
			add(txtDescripcion, gbc_txtDescripcion);
			txtDescripcion.setColumns(10);
		}
		{
			lblPrecio = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.anchor = GridBagConstraints.WEST;
			gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecio.gridx = 3;
			gbc_lblPrecio.gridy = 3;
			add(lblPrecio, gbc_lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
			gbc_txtPrecio.insets = new Insets(0, 0, 5, 0);
			gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPrecio.gridx = 4;
			gbc_txtPrecio.gridy = 3;
			add(txtPrecio, gbc_txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			lblDisponible = new JLabel("Disponible:");
			GridBagConstraints gbc_lblDisponible = new GridBagConstraints();
			gbc_lblDisponible.anchor = GridBagConstraints.WEST;
			gbc_lblDisponible.insets = new Insets(0, 0, 5, 5);
			gbc_lblDisponible.gridx = 3;
			gbc_lblDisponible.gridy = 4;
			add(lblDisponible, gbc_lblDisponible);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 4;
			add(textField, gbc_textField);
			textField.setColumns(10);
		}

	}

	private class ListListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			org.VisualizarProducto.dominio.Producto p;
			int index=list.getSelectedIndex();
			@SuppressWarnings("rawtypes")
			ListModel model = list.getModel();
			if (index!=-1){
				p=(org.VisualizarProducto.dominio.Producto) model.getElementAt(index);
				txtIdProducto.setText(String.valueOf(p.getIdProducto()));
				textNombre.setText(p.getNombre());
				txtDescripcion.setText(p.getDescripcion());
				txtPrecio.setText(String.valueOf(p.getPrecio()));
				textField.setText(String.valueOf(p.isDisponible()));
			}
		}
	}
	public void enableText(boolean enabled){
		txtIdProducto.setEnabled(false);
		textNombre.setEnabled(enabled);
		txtDescripcion.setEnabled(enabled);
		txtPrecio.setEnabled(enabled);
		textField.setEnabled(false);
	}
	public String getTxtId(){
		return txtIdProducto.getText();
	}
	public String getTxtNombre(){
		return textNombre.getText();
	}
	public String getTxtDescripcion(){
		return txtDescripcion.getText();
	}
	public String getTxtPrecio(){
		return txtPrecio.getText();
	}
	public String getTxtField(){
		return textField.getText();
	}
	
	
	public JList getListaProductos(){
		return list;
	}
}
