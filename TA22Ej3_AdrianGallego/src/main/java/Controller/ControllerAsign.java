package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import SQLConnector.SQLConnect;
import View.ViewAsign;

public class ControllerAsign implements ActionListener{

	private ViewAsign view;
	private Controller cntrl;
	
	public ControllerAsign(ViewAsign view, Controller cntrl) {
		this.view = view;
		this.cntrl = cntrl;
		this.view.btnAsignar.addActionListener(this);
	}

	public void initView() {
		view.frame.getContentPane().setLayout(null);
		view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.frame.setVisible(true);
		view.frame.setResizable(false);
		view.frame.setLocationRelativeTo(null);
		loadComboBox();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.btnAsignar.equals(e.getSource())) {
			buttonAsignar();
		}
		
	}

	private void buttonAsignar() {
		Object dni = view.cbDNI.getSelectedItem();
		Object id = view.cbID.getSelectedItem();
		
		if (dni!= null && id != null) {
			System.out.println("Dni " + dni.toString());
			System.out.println("Id " + id.toString());
			boolean state = SQLConnect.insertAsignadoA(dni.toString(), id.toString());
			if (state) {
				JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
				cntrl.goBack();
				view.frame.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "Error al asignar proyecto");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Añade cientificos o proyectos antes de asignarlos");

		}
		
	}

	private void loadComboBox() {
		ArrayList<String> dniList = SQLConnect.getListDNI();
		ArrayList<String> idProyectList = SQLConnect.getProyectoID();
		
		for (String dni : dniList) {
			view.cbDNI.addItem(dni);
		}
		
		for (String id : idProyectList) {
			view.cbID.addItem(id);
		}
		
	}

	
	
}
