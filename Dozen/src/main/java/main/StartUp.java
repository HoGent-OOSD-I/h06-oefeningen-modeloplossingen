package main;

import cui.DoosApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		DomeinController domeinController = new DomeinController();
		DoosApplicatie doosApp = new DoosApplicatie(domeinController);
		doosApp.start();
	}

}