package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddCientifico {

	public JFrame frame;
	public JTextField tfDni,tfNomApels;
	public JButton btnAdd;

	public AddCientifico() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 250);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Cientifico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(73, 25, 150, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 82, 37, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre y apelllidos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(30, 109, 114, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tfDni = new JTextField();
		tfDni.setBounds(160, 80, 120, 20);
		frame.getContentPane().add(tfDni);
		tfDni.setColumns(10);
		
		tfNomApels = new JTextField();
		tfNomApels.setColumns(10);
		tfNomApels.setBounds(160, 107, 120, 20);
		frame.getContentPane().add(tfNomApels);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(105, 156, 89, 23);
		frame.getContentPane().add(btnAdd);
	}
}
