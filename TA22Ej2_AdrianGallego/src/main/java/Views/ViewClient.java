package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.MenuBar;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.border.EtchedBorder;

public class ViewClient {

	public JFrame frame;
	public JTextArea taClientes, taVideos, taVideosClientes;
	public JButton btnAsignar;
	public JMenuItem nuevoCliente, nuevoVideo, modifyCliente, modifyVideo, deleteCliente, deleteVideo;
	public JPanel panel_1;
	public JTable table;

	public ViewClient() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 910);
		
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tabla clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(24, 11, 685, 240);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		taClientes = new JTextArea();
		taClientes.setEditable(false);
		taClientes.setBounds(10, 24, 665, 205);
		panel_1.add(taClientes);
		
		btnAsignar = new JButton("Asignar video a un usuario");
		btnAsignar.setBounds(262, 808, 214, 30);
		frame.getContentPane().add(btnAsignar);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabla videos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(24, 268, 685, 240);
		frame.getContentPane().add(panel_1_1);
		
		taVideos = new JTextArea();
		taVideos.setEditable(false);
		taVideos.setBounds(10, 24, 665, 205);
		panel_1_1.add(taVideos);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Videos y clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBounds(24, 542, 685, 240);
		frame.getContentPane().add(panel_1_1_1);
		
		taVideosClientes = new JTextArea();
		taVideosClientes.setEditable(false);
		taVideosClientes.setBounds(10, 24, 665, 205);
		panel_1_1_1.add(taVideosClientes);
		
		JMenuBar barraMenu = new JMenuBar();
				
        JMenu fileMenu = new JMenu("Añadir");
        JMenu editMenu = new JMenu("Editar");
        JMenu modifyMenu = new JMenu("Modificar");
        JMenu deleteMenu = new JMenu("Eliminar");


		nuevoCliente = new JMenuItem("Nuevo Cliente");
        nuevoVideo = new JMenuItem("Nuevo Video");
        
        modifyCliente = new JMenuItem("Editar cliente");
        
        deleteCliente = new JMenuItem("Borrar cliente");
        deleteVideo = new JMenuItem("Borrar video");
        
        modifyMenu.add(modifyCliente);
        deleteMenu.add(deleteCliente);
        deleteMenu.add(deleteVideo);
        
        editMenu.add(deleteMenu);
        editMenu.add(modifyMenu);
        fileMenu.add(nuevoCliente);
        fileMenu.add(nuevoVideo);

        barraMenu.add(editMenu);
        barraMenu.add(fileMenu);


		frame.setJMenuBar(barraMenu);

	}
}
