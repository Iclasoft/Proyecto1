package org.Integracion.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import org.BorrarProductos.presentacion.pnlBorrarProducto;
import org.Configuracion.presentacion.pnlConfigurar;
import org.IntroducirProductos.presentacion.pnlIntProductos;
import org.ModificarProductos.presentacion.pnlModificarProducto;
import org.RealizarPedidos.presentacion.pnlRealizarPedido;
import org.VisualizarPedidos.presentacion.pnlVisualizarPedidos;
import org.VisualizarProducto.presentacion.pnlVisualizarProducto;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPrincipal {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnIntroducir;
	private JPanel panel_2;
	private JButton btnRealizarUnPedido;
	private JButton btnVisualizarPedido;
	private JButton btnVisualizarProductos;
	private JButton btnEliminarProductos;
	private JButton btnModificarProductos;
	private JButton btnConfiguracin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{190, 177, 0};
		gridBagLayout.rowHeights = new int[]{203, 57, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 0;
			frame.getContentPane().add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{171, 0};
			gbl_panel_1.rowHeights = new int[]{25, 0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				btnIntroducir = new JButton("Introducir Producto");
				btnIntroducir.addActionListener(new BtnIntroducirActionListener());
				GridBagConstraints gbc_btnIntroducir = new GridBagConstraints();
				gbc_btnIntroducir.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnIntroducir.anchor = GridBagConstraints.NORTH;
				gbc_btnIntroducir.insets = new Insets(0, 0, 5, 0);
				gbc_btnIntroducir.gridx = 0;
				gbc_btnIntroducir.gridy = 0;
				panel_1.add(btnIntroducir, gbc_btnIntroducir);
			}
			{
				btnVisualizarProductos = new JButton("Visualizar Productos");
				btnVisualizarProductos.addActionListener(new BtnVisualizarProductosActionListener());
				GridBagConstraints gbc_btnVisualizarProductos = new GridBagConstraints();
				gbc_btnVisualizarProductos.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnVisualizarProductos.insets = new Insets(0, 0, 5, 0);
				gbc_btnVisualizarProductos.anchor = GridBagConstraints.NORTH;
				gbc_btnVisualizarProductos.gridx = 0;
				gbc_btnVisualizarProductos.gridy = 1;
				panel_1.add(btnVisualizarProductos, gbc_btnVisualizarProductos);
			}
			{
				btnEliminarProductos = new JButton("Eliminar Productos");
				btnEliminarProductos.addActionListener(new BtnEliminarProductosActionListener());
				GridBagConstraints gbc_btnEliminarProductos = new GridBagConstraints();
				gbc_btnEliminarProductos.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnEliminarProductos.insets = new Insets(0, 0, 5, 0);
				gbc_btnEliminarProductos.gridx = 0;
				gbc_btnEliminarProductos.gridy = 2;
				panel_1.add(btnEliminarProductos, gbc_btnEliminarProductos);
			}
			{
				btnModificarProductos = new JButton("Modificar Productos");
				btnModificarProductos.addActionListener(new BtnModificarProductosActionListener());
				GridBagConstraints gbc_btnModificarProductos = new GridBagConstraints();
				gbc_btnModificarProductos.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnModificarProductos.gridx = 0;
				gbc_btnModificarProductos.gridy = 3;
				panel_1.add(btnModificarProductos, gbc_btnModificarProductos);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.insets = new Insets(0, 0, 5, 0);
			gbc_panel_2.gridx = 1;
			gbc_panel_2.gridy = 0;
			frame.getContentPane().add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{167, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0, 0};
			gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			{
				btnVisualizarPedido = new JButton("Visualizar pedido");
				btnVisualizarPedido.addActionListener(new BtnVisualizarPedidoActionListener());
				GridBagConstraints gbc_btnVisualizarPedido = new GridBagConstraints();
				gbc_btnVisualizarPedido.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnVisualizarPedido.insets = new Insets(0, 0, 5, 0);
				gbc_btnVisualizarPedido.gridx = 0;
				gbc_btnVisualizarPedido.gridy = 0;
				panel_2.add(btnVisualizarPedido, gbc_btnVisualizarPedido);
			}
			{
				btnRealizarUnPedido = new JButton("Realizar un pedido");
				btnRealizarUnPedido.addActionListener(new BtnRealizarUnPedidoActionListener());
				GridBagConstraints gbc_btnRealizarUnPedido = new GridBagConstraints();
				gbc_btnRealizarUnPedido.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnRealizarUnPedido.gridx = 0;
				gbc_btnRealizarUnPedido.gridy = 1;
				panel_2.add(btnRealizarUnPedido, gbc_btnRealizarUnPedido);
			}
		}
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Configuraci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.anchor = GridBagConstraints.NORTH;
			gbc_panel.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel.gridwidth = 2;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			frame.getContentPane().add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				btnConfiguracin = new JButton("Configuración");
				btnConfiguracin.addActionListener(new BtnConfiguracinActionListener());
				panel.add(btnConfiguracin);
			}
		}
	}

	private class BtnIntroducirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlIntProductos());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
	private class BtnVisualizarProductosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlVisualizarProducto());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
	private class BtnEliminarProductosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlBorrarProducto());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
	private class BtnModificarProductosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlModificarProducto());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
	private class BtnVisualizarPedidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlVisualizarPedidos());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
	private class BtnRealizarUnPedidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlRealizarPedido());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
	private class BtnConfiguracinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd=new LanzarPanel(new pnlConfigurar());
			jd.setModal(true);
			jd.setVisible(true);
		}
	}
}
