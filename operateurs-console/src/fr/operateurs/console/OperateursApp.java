package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		System.out.println("***** Application Operateurs *****");
		System.out.println("Veuillez saisir le premier nombre...");
		Scanner sc = new Scanner(System.in);
		int nb1 = sc.nextInt();
		sc.nextLine();
		System.out.println("Veuillez saisir le second nombre...");
		int nb2 = sc.nextInt();
		System.out.println(nb1 + " + " + nb2 + " = " + (nb1+nb2));
		System.out.println(nb1 + " - " + nb2 + " = " + (nb1-nb2));
		System.out.println(nb1 + " * " + nb2 + " = " + (nb1*nb2));
		System.out.println(nb1 + " / " + nb2 + " = " + (nb1/nb2));
		System.out.println(nb1 + " % " + nb2 + " = " + (nb1%nb2));
		sc.close();

	}

}
