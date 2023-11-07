package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Cientifico;
import SQLConnector.SQLConnect;
import View.AddCientifico;

public class ControllerAddCientifico implements ActionListener{
	
	private Cientifico cientifico;
	private AddCientifico view;
	private Controller cntrl;
	
	public ControllerAddCientifico(Cientifico cientifico, AddCientifico view, Controller controller) {
		this.cientifico = cientifico;
		this.view = view;
		this.cntrl = controller;
		this.view.btnAdd.addActionListener(this);
	}
	
	public void initView() {
		view.frame.getContentPane().setLayout(null);
		view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.frame.setVisible(true);
		view.frame.setResizable(false);
		view.frame.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.btnAdd.equals(e.getSource())) {
			buttonAdd();
		}
		
	}

	private void buttonAdd() {
		if (validateFields()) {
			JOptionPane.showMessageDialog(null, "Rellena todos los campos");
		} else {
			if (validateDNI()) {
				setCientifico();
				boolean state = SQLConnect.insertCientifico(cientifico);
				if (state) {
					JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
					cntrl.goBack();
					view.frame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Error al añadir el cientifico");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El DNI introducido no es valido, maximo 9 caracteres");

			}
		}
	}

	private void setCientifico() {
		cientifico.setDni(view.tfDni.getText());
		cientifico.setNomApels(view.tfNomApels.getText());

	}

	private boolean validateDNI() {
		boolean valid = false;
		if (view.tfDni.getText().length() <= 9 ) {
			valid = true;
		}
		return valid;
	}

	private boolean validateFields() {
		boolean valid = false;
		if (view.tfDni.getText().isEmpty() && view.tfNomApels.getText().isEmpty()) {
			valid = true;
		}
		return valid;
	}

	
}
