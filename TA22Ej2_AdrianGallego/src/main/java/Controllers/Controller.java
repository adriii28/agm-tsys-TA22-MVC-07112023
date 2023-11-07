package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Models.Client;
import Models.Video;
import Models.VideoCliente;
import SQLConnector.SQLConnect;
import Views.AddClient;
import Views.AddVideo;
import Views.ModifyCliente;
import Views.ViewClient;

public class Controller implements ActionListener {

	private Client client;
	private Video video;
	private ViewClient view;
	private ArrayList<Client> listaClientes;
	private ArrayList<Video> listaVideos;
	private ArrayList<VideoCliente> listaVideoCliente;
	private int id;

	public Controller(Client client, ViewClient view, Video v) {
		this.client = client;
		this.view = view;
		this.video = v;
		this.view.btnAsignar.addActionListener(this);
		this.view.nuevoCliente.addActionListener(this);
		this.view.nuevoVideo.addActionListener(this);
		this.view.deleteCliente.addActionListener(this);
		this.view.modifyCliente.addActionListener(this);
		this.view.deleteVideo.addActionListener(this);
	}

	public void initView() {
		startView();
		showClients();
		showVideos();
		showClientVideos();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.nuevoCliente.equals(e.getSource())) {
			buttonAddCliente();
		} else if (view.nuevoVideo.equals(e.getSource())) {
			buttonAddVideo();
		} else if (view.btnAsignar.equals(e.getSource())) {
			buttonAsignar();
		} else if (view.deleteCliente.equals(e.getSource())) {
			buttonDelClient();
		} else if (view.modifyCliente.equals(e.getSource())) {
			buttonUpdate();
		} else if (view.deleteVideo.equals(e.getSource())) {
			buttonDelVideo();
		}
		
	}

	private void buttonAsignar() {
		int idCliente = searchClient();		
		if (idCliente!= -1) {
			int idVideo = searchVideo();
			if (idVideo != -1) {
				int resp = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Alerta!",
						JOptionPane.YES_NO_OPTION);
				if (resp == 0) {
					SQLConnect.updateClientVideo(idVideo, idCliente);
					showClients();
					showClientVideos();
					showVideos();
					JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operacion cancelada");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ningun video contiene el ID introducido", "Atencion!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ningun cliente contiene el ID introducido", "Atencion!",
					JOptionPane.ERROR_MESSAGE);
		}

		
		
	}
	
	private void buttonAddVideo() {
		view.frame.setEnabled(false);

		AddVideo addVideo = new AddVideo();
		ControllerNewVideo cv = new ControllerNewVideo(addVideo, video, this);
		cv.initView();
	}

	private void buttonAddCliente() {
		view.frame.setEnabled(false);

		AddClient addView = new AddClient();
		ControllerAdd c = new ControllerAdd(client, addView,this);
		c.initView();
		
	}

	private int searchVideo() {
		int idVideo = -1;
		
		if (listaVideos.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay videos añadidos", "Alerta",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el video",
					"Seleccionar video", JOptionPane.INFORMATION_MESSAGE);
			
			try {
				int id = Integer.valueOf(idStr);
				for (Video v : listaVideos) {
					if (v.getId() == id) {
						idVideo = v.getId();
					}
				}
				
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}

		return idVideo;
	}

	private int searchClient() {
		int idCliente = -1;
		if (listaClientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay clientes añadidos", "Alerta",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el cliente, para poder asignarle un video",
					"Seleccionar Cliente", JOptionPane.INFORMATION_MESSAGE);
			
			try {
				int id = Integer.valueOf(idStr);
				for (Client client : listaClientes) {
					if (client.getId() == id) {
						idCliente = client.getId();
					}
				}
				
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());

			}
		}
		return idCliente;
	}

	private void buttonDelClient() {
		if (listaClientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay clientes para poder eliminar", "Alerta",
					JOptionPane.ERROR_MESSAGE);
		} else {

			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el cliente que deseas eliminar",
					"Eliminar Cliente", JOptionPane.INFORMATION_MESSAGE);
			try {
				int id = Integer.valueOf(idStr);
				boolean exist = false;
				for (Client client : listaClientes) {
					if (client.getId() == id) {
						exist = true;
						
						int resp = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Alerta!",
								JOptionPane.YES_NO_OPTION);
						if (resp == 0) {
							boolean state = SQLConnect.deleteCliente(id);
							if (state) {
								showClients();
								showClientVideos();
								JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
							} else {
								JOptionPane.showMessageDialog(null, "Error. Antes de borrar un cliente, borra el video que tiene asignado");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Operacion cancelada");
						}
					}
				}

				if (!exist) {
					JOptionPane.showMessageDialog(null, "Ningun cliente contiene el ID -> " + id, "Atencion!",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	
	private void buttonDelVideo() {
		if (listaVideos.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay videos para poder eliminar", "Alerta",
					JOptionPane.ERROR_MESSAGE);
		} else {

			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el video que deseas eliminar",
					"Eliminar Video", JOptionPane.INFORMATION_MESSAGE);
			try {
				int id = Integer.valueOf(idStr);
				boolean exist = false;
				for (Video v : listaVideos) {
					if (v.getId() == id) {
						exist = true;
						int resp = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Alerta!",
								JOptionPane.YES_NO_OPTION);
						if (resp == 0) {
							boolean state = SQLConnect.deleteVideo(id);
							if (state) {
								showVideos();
								showClientVideos();
								JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
							} else {
								JOptionPane.showMessageDialog(null, "Error al borrar el video");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Operacion cancelada");
						}
					}
				}

				if (!exist) {
					JOptionPane.showMessageDialog(null, "Ningun cliente contiene el ID -> " + id, "Atencion!",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	private void buttonUpdate() {
		if (listaClientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay clientes para modificar", "Alerta", JOptionPane.ERROR_MESSAGE);
		} else {
			String idStr = JOptionPane.showInputDialog(null, "Introduce el ID de el cliente que deseas modificar",
					"Modificar Cliente", JOptionPane.INFORMATION_MESSAGE);
			try {
				id = Integer.valueOf(idStr);
				boolean exist = false;
				for (Client client : listaClientes) {
					if (client.getId() == id) {
						exist = true;
						
						view.frame.setEnabled(false);

						ModifyCliente addView = new ModifyCliente();
						ControllerModify c = new ControllerModify(client, addView,this, id);
						c.initView();
					}
				}
				if (!exist) {
					JOptionPane.showMessageDialog(null, "Ningun cliente contiene el ID -> " + id, "Atencion!",
							JOptionPane.ERROR_MESSAGE);
				} 
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	private void startView() {
		view.frame.setTitle("Clientes y videos");
		view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.frame.getContentPane().setLayout(null);
		view.frame.setVisible(true);
		view.frame.setResizable(false);
		view.frame.setLocationRelativeTo(null);

	}
	
	public void showClients() {
		listaClientes = SQLConnect.getClientes();
		String clientes = "";

		if (listaClientes.size()==0) {
			clientes = "No hay clientes";
		} else {
			for (Client client : listaClientes) {
				clientes += client.toString() + "\n";
			}
		}
		
		view.taClientes.setText(clientes);
	}

	private void showVideos() {
		listaVideos = SQLConnect.getVideos();
		String videosStr = "";
		
		if (listaVideos.size() == 0) {
			videosStr = "No hay videos";
		} else {
			for (Video v : listaVideos) {
				videosStr += v.toString() + "\n";
			}
		}
		
		view.taVideos.setText(videosStr);
	}
	
	private void showClientVideos() {
		listaVideoCliente = SQLConnect.getVideosAsignados();
		String videosStr = "";
		
		if (listaVideoCliente.size() == 0) {
			videosStr = "No hay videos asignados a los clientes";
		} else {
			for (VideoCliente vc : listaVideoCliente) {
				videosStr += vc.toString() + "\n";
			}
		}
		
		view.taVideosClientes.setText(videosStr);
		
	}

	public void goBack() {
		showClients();
		showVideos();
		showClientVideos();
		view.frame.setEnabled(true);

	}
}
