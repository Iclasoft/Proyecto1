package org.BorrarProductos.presentacion;

import javax.swing.JPanel;
import javax.swing.ListModel;

import org.BorrarProductos.dominio.GestorBorrarProducto;
import org.ModificarProductos.dominio.GestorModificarProducto;
import org.VisualizarProducto.presentacion.pnlVisualizarProducto;

import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pnlBorrarProducto extends JPanel {
	private pnlVisualizarProducto panel;
	private JButton btnBorrar;

	/**
	 * Create the panel.
	 */
	public pnlBorrarProducto() {
		
		panel = new pnlVisualizarProducto();
		add(panel);
		panel.enableText(false);
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		add(btnBorrar);

	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			org.VisualizarProducto.dominio.Producto p;
			JList list = panel.getListaProductos();
			int index=list.getSelectedIndex();
			@SuppressWarnings("rawtypes")
			ListModel model = list.getModel();
			if (index!=-1){
				p=(org.VisualizarProducto.dominio.Producto) model.getElementAt(index);
				try {
					new GestorBorrarProducto().borrarProducto(p);
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
