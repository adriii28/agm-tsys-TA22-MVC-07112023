package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import Model.Cientifico;
import Model.Proyecto;
import Model.ProyectoAsignado;
import SQLConnector.SQLConnect;
import View.AddCientifico;
import View.AddProyecto;
import View.View;
import View.ViewAsign;

public class Controller implements ActionListener{

	private Cientifico cientifico;
	private Proyecto proyecto;
	private View view;
	private List<Cientifico> listaCientificos;
	private List<Proyecto> listaProyectos;
	private List<ProyectoAsignado> listaProyectosAsignados;


	
	public Controller(Cientifico cientifico, Proyecto proyecto, View view) {
		this.cientifico = cientifico;
		this.proyecto = proyecto;
		this.view = view;
		this.view.newCientifico.addActionListener(this);
		this.view.newProject.addActionListener(this);
		this.view.listCientifico.addActionListener(this);
		this.view.listProyecto.addActionListener(this);
		this.view.asign.addActionListener(this);
		this.view.listAsign.addActionListener(this);
	}
	
	public void initView() {
		view.frame.getContentPane().setLayout(null);
		view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.frame.setVisible(true);
		view.frame.setResizable(false);
		view.frame.setLocationRelativeTo(null);
		showCientificos();
	}

	public void goBack() {
		view.frame.setEnabled(true);
		showCientificos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.newCientifico.equals(e.getSource())) {
			buttonAddCientifico();
		} else if (view.newProject.equals(e.getSource())) {
			buttonAddProyecto();
		} else if (view.listCientifico.equals(e.getSource())) {
			showCientificos();
		} else if (view.listProyecto.equals(e.getSource())) {
			showProyectos();
		} else if (view.asign.equals(e.getSource())) {
			buttonAsign();
		} else if (view.listAsign.equals(e.getSource())) {
			showPrAsignados();
		}
		
	}

	private void showPrAsignados() {
		view.lblTabla.setText("Proyectos Asignados");
		listaProyectosAsignados = SQLConnect.getProyectosAsignados();
		String proyectosAs = "";

		if (listaProyectosAsignados.size()==0) {
			proyectosAs = "No hay ningun proyecto asignado";
		} else {
			for (ProyectoAsignado pa : listaProyectosAsignados) {
				proyectosAs += pa.toString() + "\n";
			}
		}
		
		view.taListar.setText(proyectosAs);
		
	}

	private void buttonAsign() {		
		view.frame.setEnabled(false);
		ViewAsign viewA = new ViewAsign();
		ControllerAsign cntrAs = new ControllerAsign(viewA, this);
		cntrAs.initView();
		
		
	}

	private void showProyectos() {
		view.lblTabla.setText("Proyectos");
		listaProyectos = SQLConnect.getProyectos();
		String proyectos = "";

		if (listaProyectos.size()==0) {
			proyectos = "No hay proyectos";
		} else {
			for (Proyecto p : listaProyectos) {
				proyectos += p.toString() + "\n";
			}
		}
		
		view.taListar.setText(proyectos);
		
	}

	private void showCientificos() {
		view.lblTabla.setText("Cientificos");
		listaCientificos = SQLConnect.getCientificos();
		String cientificos = "";

		if (listaCientificos.size()==0) {
			cientificos = "No hay cientificos";
		} else {
			for (Cientifico c : listaCientificos) {
				cientificos += c.toString() + "\n";
			}
		}
		
		view.taListar.setText(cientificos);
		
	}

	private void buttonAddProyecto() {
		view.frame.setEnabled(false);
		AddProyecto viewAdd = new AddProyecto();
		ControllerAddProyecto cntrPr = new ControllerAddProyecto(proyecto, viewAdd, this);
		cntrPr.initView();
	}

	private void buttonAddCientifico() {
		view.frame.setEnabled(false);
		AddCientifico viewAdd = new AddCientifico();
		ControllerAddCientifico cntrCiet = new ControllerAddCientifico(cientifico, viewAdd, this);
		cntrCiet.initView();
		
	}
	
	
}
