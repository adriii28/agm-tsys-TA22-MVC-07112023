package View;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ViewAsign {

	public JFrame frame;
	public JComboBox cbDNI, cbID;
	public JButton btnAsignar;

	public ViewAsign() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		cbDNI = new JComboBox();
		cbDNI.setBounds(59, 106, 120, 22);
		frame.getContentPane().add(cbDNI);
		
		cbID = new JComboBox();
		cbID.setBounds(250, 107, 120, 20);
		frame.getContentPane().add(cbID);
		
		JLabel lblNewLabel = new JLabel("DNI Cientifico");
		lblNewLabel.setBounds(59, 81, 94, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIdProyecto = new JLabel("ID Proyecto");
		lblIdProyecto.setBounds(250, 82, 94, 14);
		frame.getContentPane().add(lblIdProyecto);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(162, 184, 89, 23);
		frame.getContentPane().add(btnAsignar);
		
		JLabel lblNewLabel_1 = new JLabel("Asignar proyecto a cientifico");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(77, 29, 267, 20);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
