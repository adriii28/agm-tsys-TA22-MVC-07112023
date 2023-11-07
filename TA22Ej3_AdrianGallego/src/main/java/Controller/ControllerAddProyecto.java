package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Proyecto;
import SQLConnector.SQLConnect;
import View.AddProyecto;

public class ControllerAddProyecto implements ActionListener {

	private Proyecto proyecto;
	private AddProyecto view;
	private Controller cntrl;

	public ControllerAddProyecto(Proyecto proyecto, AddProyecto view, Controller controller) {
		this.proyecto = proyecto;
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
			if (validateID()) {
				setProyecto();
				boolean state = SQLConnect.insertProyecto(proyecto);
				if (state) {
					JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
					cntrl.goBack();
					view.frame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Error al añadir el proyecto");
				}

			} else {
				JOptionPane.showMessageDialog(null, "El ID introducido no es valido, maximo 4 caracteres");
			}
		}
	}

	private void setProyecto() {

		proyecto.setId(view.tfId.getText());
		proyecto.setNombre(view.tfNombreProyecto.getText());
		proyecto.setHoras(Integer.valueOf(view.tfHoras.getText()));

	}

	private boolean validateID() {
		boolean valid = false;
		if (view.tfId.getText().length() <= 4) {
			valid = true;
		}
		return valid;
	}

	private boolean validateFields() {
		boolean valid = false;
		if (view.tfId.getText().isEmpty() && view.tfNombreProyecto.getText().isEmpty()
				&& view.tfHoras.getText().isEmpty()) {
			valid = true;
		}
		return valid;
	}

}
