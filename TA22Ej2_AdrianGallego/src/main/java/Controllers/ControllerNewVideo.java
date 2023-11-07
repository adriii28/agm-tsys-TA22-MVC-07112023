package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Video;
import SQLConnector.SQLConnect;
import Views.AddVideo;

public class ControllerNewVideo implements ActionListener {
	
	private AddVideo viewAddVideo;
	private Video video;
	private Controller controller;
	
	
	public ControllerNewVideo(AddVideo viewAddVideo, Video video, Controller controller) {
		this.viewAddVideo = viewAddVideo;
		this.video = video;
		this.controller = controller;
		this.viewAddVideo.btnAdd.addActionListener(this);
	}
	
	public void initView() {
		startViewAddV();
	}
	
	private void startViewAddV() {
		viewAddVideo.frame.setTitle("Añadir video");
		viewAddVideo.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewAddVideo.frame.getContentPane().setLayout(null);
		viewAddVideo.frame.setVisible(true);
		viewAddVideo.frame.setResizable(false);
		viewAddVideo.frame.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewAddVideo.btnAdd.equals(e.getSource())) {
			buttonAdd();
		}	
	}

	private void buttonAdd() {
		if (validateTextFields()) {
			JOptionPane.showMessageDialog(null, "Rellena todos los campos");
		} else {
			setVideo();
			boolean state = SQLConnect.insertVideo(video);
			if (state) {
				JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
				controller.goBack();
				viewAddVideo.frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Introduce el formato de la fecha correctamente");

			}
		}
		
	}

	private void setVideo() {
		video.setTitle(viewAddVideo.tfTitulo.getText());
		video.setDirector(viewAddVideo.tfDirector.getText());
		
	}

	private boolean validateTextFields() {
		boolean validate = false;
		if (viewAddVideo.tfDirector.getText().isEmpty() || viewAddVideo.tfTitulo.getText().isEmpty()) {
			validate = true;
		}
		return validate;
	}
}
