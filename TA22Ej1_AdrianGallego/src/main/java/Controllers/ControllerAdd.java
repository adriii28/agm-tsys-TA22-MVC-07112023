package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Client;
import SQLConnector.SQLConnect;
import Views.AddClient;

public class ControllerAdd implements ActionListener {
	
	private AddClient viewAdd;
	private Client client;
	private Controller controller;

	public ControllerAdd(Client client, AddClient view, Controller controller) {
		this.client = client;
		this.viewAdd = view;
		this.controller = controller;
		this.viewAdd.btnAdd.addActionListener(this);

	}
	
	public void initView() {
		startViewAddC();
	}
	
	
	private void startViewAddC() {
		viewAdd.frame.setTitle("Añadir clientes");
		viewAdd.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewAdd.frame.getContentPane().setLayout(null);
		viewAdd.frame.setVisible(true);
		viewAdd.frame.setResizable(false);
		viewAdd.frame.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewAdd.btnAdd.equals(e.getSource())) {
			buttonAdd();
		}
	}
	
	private void buttonAdd() {
		if (validateTextFields()) {
			JOptionPane.showMessageDialog(null, "Rellena todos los campos");
		} else {
			if (validateDNI()) {
				boolean stateClient = setClient();
				if (stateClient) {
					boolean state = SQLConnect.insertData(client);
					if (state) {
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						controller.goBack();
						viewAdd.frame.dispose();
						
					//cambia a el otro
					} else {
						JOptionPane.showMessageDialog(null, "Introduce el formato de la fecha correctamente");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "El DNI debe de menos de 11 caracteres");
			}
		}
	}
	
	private boolean setClient() {
		boolean correct = false;
		try {
			client.setNombre(viewAdd.tfNombre.getText());
			client.setApellidos(viewAdd.tfApellido.getText());
			client.setDireccion(viewAdd.tfDireccion.getText());
			client.setDni(Integer.valueOf(viewAdd.tfDNI.getText()));
			client.setFecha(viewAdd.tfFecha.getText());
			correct = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce el DNI correctamente, solo numeros");
			correct = false;
		}
		return correct;

	}
	
	private boolean validateDNI() {
		boolean dni = false;
		if (viewAdd.tfDNI.getText().length() <= 11) {
			dni = true;
		}
		return dni;
	}

	private boolean validateTextFields() {
		boolean validate = false;
		if (viewAdd.tfNombre.getText().isEmpty() || viewAdd.tfApellido.getText().isEmpty()
				|| viewAdd.tfDireccion.getText().isEmpty() || viewAdd.tfDNI.getText().isEmpty()
				|| viewAdd.tfFecha.getText().isEmpty()) {
			validate = true;
		}
		return validate;
	}


}
