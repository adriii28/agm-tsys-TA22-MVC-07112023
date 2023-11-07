package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddProyecto {

	public JFrame frame;
	public JTextField tfId, tfNombreProyecto,tfHoras;
	public JButton btnAdd;

	public AddProyecto() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 275);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Proyecto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(73, 25, 150, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 82, 37, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre proyecto");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(30, 109, 114, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tfId = new JTextField();
		tfId.setBounds(160, 80, 120, 20);
		frame.getContentPane().add(tfId);
		tfId.setColumns(10);
		
		tfNombreProyecto = new JTextField();
		tfNombreProyecto.setColumns(10);
		tfNombreProyecto.setBounds(160, 107, 120, 20);
		frame.getContentPane().add(tfNombreProyecto);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(110, 178, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Horas");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(30, 136, 114, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		tfHoras = new JTextField();
		tfHoras.setColumns(10);
		tfHoras.setBounds(160, 134, 120, 20);
		frame.getContentPane().add(tfHoras);
	}
}
