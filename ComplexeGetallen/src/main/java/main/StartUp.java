package main;

import cui.ComplexApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new ComplexApplicatie(new DomeinController()).start();
	}

}