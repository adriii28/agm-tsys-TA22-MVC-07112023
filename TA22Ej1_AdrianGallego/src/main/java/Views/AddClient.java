package Views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AddClient {

	public JFrame frame;
	public JTextField tfNombre, tfApellido,tfDireccion,tfDNI,tfFecha;
	public JButton btnAdd;

	
	public AddClient() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 320);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(44, 67, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(115, 67, 110, 20);
		frame.getContentPane().add(tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(115, 95, 110, 20);
		frame.getContentPane().add(tfApellido);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(44, 95, 60, 14);
		frame.getContentPane().add(lblApellidos);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(115, 123, 110, 20);
		frame.getContentPane().add(tfDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(44, 123, 60, 14);
		frame.getContentPane().add(lblDireccion);
		
		tfDNI = new JTextField();
		tfDNI.setColumns(10);
		tfDNI.setBounds(115, 154, 110, 20);
		frame.getContentPane().add(tfDNI);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(44, 154, 46, 14);
		frame.getContentPane().add(lblDni);
		
		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(115, 182, 110, 20);
		frame.getContentPane().add(tfFecha);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(44, 182, 60, 14);
		frame.getContentPane().add(lblFecha);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(80, 233, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("Formato (YYYY-MM-DD)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(101, 207, 145, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Añadir cliente");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(56, 31, 160, 20);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
