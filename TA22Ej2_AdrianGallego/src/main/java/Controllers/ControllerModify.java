package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Client;
import SQLConnector.SQLConnect;
import Views.ModifyCliente;

public class ControllerModify implements ActionListener{

	private Client client;
	private ModifyCliente viewModify;
	private Controller controller;
	private int id;

	public ControllerModify(Client client, ModifyCliente view, Controller controller, int id) {
		this.client = client;
		this.viewModify = view;
		this.id = id;
		this.controller = controller;
		this.viewModify.btnModify.addActionListener(this);

	}
	
	public void initView() {
		startViewModify();
	}

	private void startViewModify() {
		viewModify.frame.setTitle("Modificar clientes");
		viewModify.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewModify.frame.getContentPane().setLayout(null);
		viewModify.frame.setVisible(true);
		viewModify.frame.setResizable(false);
		viewModify.frame.setLocationRelativeTo(null);
		
		viewModify.tfNombre.setText(client.getNombre());
		viewModify.tfApellido.setText(client.getApellidos());
		viewModify.tfDireccion.setText(client.getDireccion());
		viewModify.tfDNI.setText(String.valueOf(client.getDni()));
		viewModify.tfFecha.setText(client.getFecha());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewModify.btnModify.equals(e.getSource())) {
			buttonModify();
		}
	}

	private void buttonModify() {
		if (validateTextFields()) {
			JOptionPane.showMessageDialog(null, "Rellena todos los campos");
		} else {
			if (validateDNI()) {
				boolean stateClient = setClient();
				if (stateClient) {
					boolean state = SQLConnect.updateData(client);
					if (state) {
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						controller.goBack();
						viewModify.frame.dispose();
		
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
			client.setId(id);
			client.setNombre(viewModify.tfNombre.getText());
			client.setApellidos(viewModify.tfApellido.getText());
			client.setDireccion(viewModify.tfDireccion.getText());
			client.setDni(Integer.valueOf(viewModify.tfDNI.getText()));
			client.setFecha(viewModify.tfFecha.getText());
			correct = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce el DNI correctamente, solo numeros");
			correct = false;
		}
		return correct;

	}
	
	private boolean validateDNI() {
		boolean dni = false;
		if (viewModify.tfDNI.getText().length() <= 11) {
			dni = true;
		}
		return dni;
	}
	
	private boolean validateTextFields() {
		boolean validate = false;
		if (viewModify.tfNombre.getText().isEmpty() || viewModify.tfApellido.getText().isEmpty()
				|| viewModify.tfDireccion.getText().isEmpty() || viewModify.tfDNI.getText().isEmpty()
				|| viewModify.tfFecha.getText().isEmpty()) {
			validate = true;
		}
		return validate;
	}
}
