package TA22Ej2_AdrianGallego.TA22Ej2_AdrianGallego;

import Controllers.Controller;
import Models.Client;
import Models.Video;
import Views.ViewClient;

public class App {
	public static void main(String[] args) {
		Client c = new Client();
		Video v = new Video();
		ViewClient vu = new ViewClient();
		Controller cnt = new Controller(c, vu,v);
		cnt.initView();
	}
}
