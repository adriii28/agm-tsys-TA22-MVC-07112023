package TA22Ej3_AdrianGallego.TA22Ej3_AdrianGallego;

import Controller.Controller;
import Model.Cientifico;
import Model.Proyecto;
import View.View;

public class App {
	public static void main(String[] args) {
		Cientifico c = new Cientifico();
		Proyecto p = new Proyecto();
		View v = new View(); 
		Controller cntrl = new Controller(c, p, v);
		cntrl.initView();
	}
}
