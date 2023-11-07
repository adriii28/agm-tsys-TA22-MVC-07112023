package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Models.Client;
import SQLConnector.SQLConnect;
import Views.AddClient;
import Views.ModifyCliente;
import Views.ViewClient;

public class Controller implements ActionListener {

	private Client client;
	private ViewClient view;
	private ArrayList<Client> listaClientes;
	private int id;

	public Controller(Client client, ViewClient view) {
		this.client = client;
		this.view = view;
		this.view.btnAdd.addActionListener(this);
		this.view.btnDelUser.addActionListener(this);
		this.view.btnUpdateUser.addActionListener(this);
	}

	public void initView() {
		startView();
		showClients();
	}
	
	public void goBack() {
		showClients();
		view.frame.setEnabled(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.btnAdd.equals(e.getSource())) {
			
			view.frame.setEnabled(false);

			AddClient addView = new AddClient();
			ControllerAdd c = new ControllerAdd(client, addView,this);
			c.initView();

		} else if (view.btnDelUser.equals(e.getSource())) {
			buttonDel();
		} else if (view.btnUpdateUser.equals(e.getSource())) {
			buttonUpdate();
		}
		
	}



	private void buttonDel() {
		if (listaClientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay clientes para poder eliminar", "Alerta",
					JOptionPane.ERROR_MESSAGE);
		} else {

			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el cliente que deseas eliminar",
					"Eliminar Cliente", JOptionPane.INFORMATION_MESSAGE);
			try {
				int id = Integer.valueOf(idStr);
				boolean exist = false;
				for (Client client : listaClientes) {
					if (client.getId() == id) {
						exist = true;
						
						int resp = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Alerta!",
								JOptionPane.YES_NO_OPTION);
						if (resp == 0) {
							SQLConnect.deleteData(id);
							showClients();
							JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "Operacion cancelada");
						}
					}
				}

				if (!exist) {
					JOptionPane.showMessageDialog(null, "Ningun cliente contiene el ID -> " + id, "Atencion!",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	private void buttonUpdate() {
		if (listaClientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay clientes para modificar", "Alerta", JOptionPane.ERROR_MESSAGE);
		} else {
			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el cliente que deseas modificar",
					"Modificar Cliente", JOptionPane.INFORMATION_MESSAGE);
			try {
				id = Integer.valueOf(idStr);
				boolean exist = false;
				for (Client client : listaClientes) {
					if (client.getId() == id) {
						exist = true;
						
						view.frame.setEnabled(false);

						ModifyCliente addView = new ModifyCliente();
						ControllerModify c = new ControllerModify(client, addView,this, id);
						c.initView();
					}
				}
				if (!exist) {
					JOptionPane.showMessageDialog(null, "Ningun cliente contiene el ID -> " + id, "Atencion!",
							JOptionPane.ERROR_MESSAGE);
				} 
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	

	

	private void startView() {
		view.frame.setTitle("Clientes");
		view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.frame.getContentPane().setLayout(null);
		view.frame.setVisible(true);
		view.frame.setResizable(false);
		view.frame.setLocationRelativeTo(null);

	}
	

	public void showClients() {
		listaClientes = SQLConnect.getValues();
		String clientes = "";

		if (listaClientes.size()==0) {
			clientes = "No hay clientes";
		} else {
			for (Client client : listaClientes) {
				clientes += client.toString() + "\n";
			}
		}
		
		view.taClientes.setText(clientes);
	}
}
