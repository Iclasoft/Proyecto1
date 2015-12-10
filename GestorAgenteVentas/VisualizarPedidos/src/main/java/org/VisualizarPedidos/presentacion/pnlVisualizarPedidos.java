package org.VisualizarPedidos.presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.border.TitledBorder;

import org.VisualizarPedidos.dominio.GestorPedido;
import org.VisualizarPedidos.dominio.Pedido;
import org.VisualizarPedidos.dominio.Producto;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class pnlVisualizarPedidos extends JPanel{
	
	private GestorPedido gp = new GestorPedido();
	private List<Object> pedidos;
	private JTextArea taProductos;
	private JScrollPane scrollPane_1;
	private JTextArea txtCliente;
	private JPanel panel;
	private JList lstPedidos;
	private DefaultListModel lstPedidosModel = new DefaultListModel();
	private JScrollPane scrollPane;
	private JPanel panelPrincipal;
	public pnlVisualizarPedidos() {
		setLayout(new BorderLayout(0, 0));
		
		panelPrincipal = new JPanel();
		add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 8;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panelPrincipal.add(scrollPane, gbc_scrollPane);
		
		lstPedidos = new JList(lstPedidosModel);
		lstPedidos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int idpedido = (Integer)lstPedidosModel.getElementAt(lstPedidos.getSelectedIndex());
				
				for(Object k: pedidos){
					Pedido p = (Pedido) k;
					if(idpedido == p.getIdPedido()){
						txtCliente.setText(p.getCliente().toString());
						String txt = "";
						for(List<Object> m : p.getListaProductos()){
							for(Object pr : m){
								Producto pro = (Producto) pr;
								txt += pro.toString()+"\n";
							}
						}
						taProductos.setText(txt);
					}
				}
			}
		});
		scrollPane.setViewportView(lstPedidos);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 11;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 1;
		panelPrincipal.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtCliente = new JTextArea();
		panel.add(txtCliente, BorderLayout.CENTER);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.gridwidth = 11;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 6;
		gbc_scrollPane_1.gridy = 5;
		panelPrincipal.add(scrollPane_1, gbc_scrollPane_1);
		
		taProductos = new JTextArea();
		scrollPane_1.setViewportView(taProductos);
		
		cargarPedidos();
	}
	
	public void cargarPedidos(){
		try {
			pedidos = gp.visualizarPedidos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Object l : pedidos){
			Pedido p = (Pedido) l;
			lstPedidosModel.addElement(p.getIdPedido());
		}
	}

}
