package TA22Ej1_AdrianGallego.TA22Ej1_AdrianGallego;

import Controllers.Controller;
import Models.Client;
import Views.ViewClient;

public class App {
	public static void main(String[] args) {
		Client c = new Client();
		ViewClient vu = new ViewClient();
		Controller cnt = new Controller(c, vu);
		cnt.initView();

	}
}
