package org.ModificarProductos.presentacion;

import javax.swing.JPanel;
import javax.swing.ListModel;

import org.ModificarProductos.dominio.GestorModificarProducto;
import org.VisualizarProducto.dominio.GestorProducto;
import org.VisualizarProducto.presentacion.pnlVisualizarProducto;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pnlModificarProducto extends JPanel {
	private pnlVisualizarProducto panel;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public pnlModificarProducto() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new pnlVisualizarProducto();
		add(panel);
		panel.enableText(true);
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new BtnModificarActionListener());
		add(btnModificar);

	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			org.VisualizarProducto.dominio.Producto p;
			JList list = panel.getListaProductos();
			int index=list.getSelectedIndex();
			@SuppressWarnings("rawtypes")
			ListModel model = list.getModel();
			if (index!=-1){
				p=(org.VisualizarProducto.dominio.Producto) model.getElementAt(index);
				p.setNombre(panel.getTxtNombre());
				p.setDescripcion(panel.getTxtDescripcion());
				p.setPrecio(Double.parseDouble(panel.getTxtPrecio()));
				
				try {
					new GestorModificarProducto().modificarProducto(p);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
