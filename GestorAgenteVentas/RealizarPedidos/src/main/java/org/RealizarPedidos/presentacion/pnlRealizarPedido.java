package org.RealizarPedidos.presentacion;

import javax.swing.JPanel;


import org.RealizarPedidos.dominio.Cliente;
import org.RealizarPedidos.dominio.GestorClientes;
import org.RealizarPedidos.dominio.GestorPedido;
import org.VisualizarProducto.dominio.Producto;
import org.VisualizarProducto.presentacion.pnlVisualizarProducto;
import org.jdom.JDOMException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class pnlRealizarPedido extends JPanel {
	private JPanel panel;
	private JButton btnAadirProducto;
	private JButton btnNuevoCliente;
	private JTextField txtCantidad;
	private JLabel lblCliente;
	private JTextField txtDni;
	private JButton btnRealizarPedido;
	private List<List<Object>> productospedidos;
	private JPanel pnl;

	/**
	 * Create the panel.
	 */
	public pnlRealizarPedido() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		pnl=this;
		productospedidos=new ArrayList<List<Object>>();
		{
			panel = new pnlVisualizarProducto();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			add(panel, gbc_panel);
		}
		{
			lblCliente = new JLabel("dni:");
			GridBagConstraints gbc_lblCliente = new GridBagConstraints();
			gbc_lblCliente.anchor = GridBagConstraints.EAST;
			gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblCliente.gridx = 2;
			gbc_lblCliente.gridy = 0;
			add(lblCliente, gbc_lblCliente);
		}
		{
			txtDni = new JTextField();
			GridBagConstraints gbc_txtDni = new GridBagConstraints();
			gbc_txtDni.insets = new Insets(0, 0, 5, 5);
			gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDni.gridx = 3;
			gbc_txtDni.gridy = 0;
			add(txtDni, gbc_txtDni);
			txtDni.setColumns(10);
		}
		{
			btnAadirProducto = new JButton("Añadir Producto");
			btnAadirProducto.addActionListener(new BtnAadirProductoActionListener());
			GridBagConstraints gbc_btnAadirProducto = new GridBagConstraints();
			gbc_btnAadirProducto.anchor = GridBagConstraints.EAST;
			gbc_btnAadirProducto.insets = new Insets(0, 0, 5, 5);
			gbc_btnAadirProducto.gridx = 0;
			gbc_btnAadirProducto.gridy = 1;
			add(btnAadirProducto, gbc_btnAadirProducto);
		}
		{
			txtCantidad = new JTextField();
			GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
			gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
			gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCantidad.gridx = 1;
			gbc_txtCantidad.gridy = 1;
			add(txtCantidad, gbc_txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnNuevoCliente = new JButton("Nuevo Cliente");
			btnNuevoCliente.addActionListener(new BtnNuevoClienteActionListener());
			GridBagConstraints gbc_btnNuevoCliente = new GridBagConstraints();
			gbc_btnNuevoCliente.anchor = GridBagConstraints.EAST;
			gbc_btnNuevoCliente.insets = new Insets(0, 0, 5, 5);
			gbc_btnNuevoCliente.gridx = 0;
			gbc_btnNuevoCliente.gridy = 2;
			add(btnNuevoCliente, gbc_btnNuevoCliente);
		}
		{
			btnRealizarPedido = new JButton("Realizar Pedido");
			btnRealizarPedido.addActionListener(new BtnRealizarPedidoActionListener());
			GridBagConstraints gbc_btnRealizarPedido = new GridBagConstraints();
			gbc_btnRealizarPedido.anchor = GridBagConstraints.EAST;
			gbc_btnRealizarPedido.insets = new Insets(0, 0, 0, 5);
			gbc_btnRealizarPedido.gridx = 0;
			gbc_btnRealizarPedido.gridy = 3;
			add(btnRealizarPedido, gbc_btnRealizarPedido);
		}

	}

	private class BtnAadirProductoActionListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			List<Object> l= new ArrayList<Object>();
			l.add(((pnlVisualizarProducto) panel).getListaProductos().getSelectedValue());
			l.add(Integer.valueOf(txtCantidad.getText()));
			productospedidos.add(l);
		}
	}
	private class BtnNuevoClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog nuevocli=new DialogNuevoCliente();
			nuevocli.setVisible(true);
		}
	}
	private class BtnRealizarPedidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				
				Cliente cli= new GestorClientes().leerCliente(txtDni.getText());
				if(cli==null){
					JOptionPane.showMessageDialog(pnl, "Error", "el dni introducido no corresponde a ningun cliente de la base de datos",JOptionPane.ERROR_MESSAGE);
				}
				if(productospedidos.isEmpty()){
					JOptionPane.showMessageDialog(pnl, "Error", "no hay productos introducidos",JOptionPane.ERROR_MESSAGE);
				}
				else{
					try {
						new GestorPedido().realizarPedido(productospedidos, cli);
					} catch (AddressException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (JDOMException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
