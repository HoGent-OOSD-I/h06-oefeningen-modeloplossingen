package main;

import cui.KapitaalApplicatie;
import domein.DomeinController;

public class 3StartUp {

	public static void main(String[] args) {
		new KapitaalApplicatie(new DomeinController()).start();
	}

}
