package View;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class View {

	public JFrame frame;
	public JMenuItem listCientifico, listProyecto, newCientifico, newProject, asign, listAsign;
	public JTextArea taListar;
	public JLabel lblTabla;

	public View() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		taListar = new JTextArea();
		taListar.setEditable(false);
		taListar.setBounds(75, 71, 600, 400);
		frame.getContentPane().add(taListar);
		
		JLabel lblNewLabel = new JLabel("Mostrando tabla:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(75, 34, 150, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblTabla = new JLabel("Cientificos");
		lblTabla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTabla.setBounds(223, 34, 180, 20);
		frame.getContentPane().add(lblTabla);
		
		JMenuBar barraMenu = new JMenuBar();
		
        JMenu fileMenu = new JMenu("Añadir");
        JMenu listMenu = new JMenu("Listar");
        JMenu asignMenu = new JMenu("Asignar");

		newCientifico = new JMenuItem("Nuevo Cientifico");
		newProject = new JMenuItem("Nuevo Proyecto");
            
		listCientifico = new JMenuItem("Listar Cientificos");
		listProyecto = new JMenuItem("Listar Proyectos");
		listAsign = new JMenuItem("Listar proyectos asignados");
		
		asign = new JMenuItem("Asignar proyecto");
		
		listMenu.add(listCientifico);
		listMenu.add(listProyecto);
		listMenu.add(listAsign);

        fileMenu.add(newCientifico);
        fileMenu.add(newProject);
        
        asignMenu.add(asign);
        
        barraMenu.add(fileMenu);
        barraMenu.add(listMenu);
        barraMenu.add(asignMenu);


		frame.setJMenuBar(barraMenu);
	}
}
