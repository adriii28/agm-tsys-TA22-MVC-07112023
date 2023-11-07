package Views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AddVideo {

	public JFrame frame;
	public JTextField tfTitulo, tfDirector;
	public JButton btnAdd;

	
	public AddVideo() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 250);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(44, 67, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(115, 67, 110, 20);
		frame.getContentPane().add(tfTitulo);
		
		tfDirector = new JTextField();
		tfDirector.setColumns(10);
		tfDirector.setBounds(115, 95, 110, 20);
		frame.getContentPane().add(tfDirector);
		
		JLabel lblApellidos = new JLabel("Director");
		lblApellidos.setBounds(44, 95, 60, 14);
		frame.getContentPane().add(lblApellidos);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(91, 141, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_2 = new JLabel("Añadir video");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(56, 31, 160, 20);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
