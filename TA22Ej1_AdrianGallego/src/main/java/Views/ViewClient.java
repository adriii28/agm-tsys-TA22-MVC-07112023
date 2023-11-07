package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;

public class ViewClient {

	public JFrame frame;
	public JTextArea taClientes;
	public JButton btnDelUser, btnUpdateUser,btnAdd;
	public JPanel panel_1;
	public JTable table;

	public ViewClient() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tabla clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(24, 11, 685, 377);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		taClientes = new JTextArea();
		taClientes.setEditable(false);
		taClientes.setBounds(10, 24, 665, 342);
		panel_1.add(taClientes);
		
		btnDelUser = new JButton("Eliminar usuario");
		btnDelUser.setBounds(293, 410, 150, 30);
		frame.getContentPane().add(btnDelUser);
		
		btnUpdateUser = new JButton("Modificar usuario");
		btnUpdateUser.setBounds(453, 410, 150, 30);
		frame.getContentPane().add(btnUpdateUser);
		
		btnAdd = new JButton("Añadir usuario");
		btnAdd.setBounds(133, 410, 150, 30);
		frame.getContentPane().add(btnAdd);
		
		
	}
}
