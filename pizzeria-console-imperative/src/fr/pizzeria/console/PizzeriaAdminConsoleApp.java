package fr.pizzeria.console;

import java.util.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] listePizzas = {{"PEP","Peperoni","12.50"},
				{"MAR","Margherita","14.00"},
				{"REI","La Reine","11.50"},
				{"FRO","La 4 fromage","12.00"},
				{"CAN","La cannibale","12.50"},
				{"SAV","La savoyarde","13.00"},
				{"ORI","L'orientale","13.50"},
				{"IND","L'indienne","14.00"}};	
		String[] pizza = new String[3];
		int pizzaPick = 0;
		int choix = 0;
		while (choix != 99){ 
			System.out.println("***** Pizzeria Administration *****\n1. Lister les pizzas\n2. Ajouter une nouvelle pizza\n3. Mettre à jour une pizza\n4. Supprimer une pizza\n99. Sortir");
			choix = sc.nextInt();	
			sc.nextLine();
			switch (choix){
			case 1 :

				printPizzas(listePizzas);
				break;
			case 2 :
				printPizzas(listePizzas);
				System.out.println("Veuillez saisir le code");
				pizza[0] = sc.nextLine();
				System.out.println("Veuillez saisir le nom (sans espaces)");
				pizza[1] = sc.nextLine();
				System.out.println("Veuillez saisir le prix");
				pizza[2] = sc.nextLine();
				listePizzas = addPizza(listePizzas, pizza);
				System.out.println("\n");
				break;
			case 3 :
				printPizzas(listePizzas);
				System.out.println("Veuillez choisir le numéro de la pizza");
				pizzaPick = sc.nextInt();sc.nextLine();
				if (pizzaPick != 99){
					System.out.println("Veuillez saisir le code");
					pizza[0] = sc.nextLine();
					System.out.println("Veuillez saisir le nom (sans espaces)");
					pizza[1] = sc.nextLine();
					System.out.println("Veuillez saisir le prix");
					pizza[2] = sc.nextLine();
					listePizzas = updatePizza(listePizzas, pizzaPick, pizza);
				}
				System.out.println("\n");
				break;
			case 4 :
				printPizzas(listePizzas);
				System.out.println("Veuillez choisir le numéro de la pizza");
				pizzaPick = sc.nextInt();sc.nextLine();
				if (pizzaPick != 99){
					listePizzas = removePizza(listePizzas, pizzaPick);
				}
				System.out.println("\n");
				break;
			case 99 :
				System.out.println("Au revoir !");
			default :
				break;
			}
		}
		sc.close();
	}

	public static void printPizzas(String[][] listePizzas){
		for (String[] pizza : listePizzas){
			System.out.println(pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+" €)");
		}
		System.out.println("\n");
	}
	
	public static String[][] addPizza(String[][] listePizzas, String[] newPizza){
		int size = listePizzas.length;
		String [][] newList = Arrays.copyOf(listePizzas, size+1);
		newList[size] = newPizza;
		return newList;
	}
	
	public static String[][] updatePizza(String[][] listePizzas, int rank, String[] newPizza){
		listePizzas[rank-1]=newPizza;
		return listePizzas;
	}
	
	public static String[][] removePizza(String[][] listePizzas, int rank){
		int size = listePizzas.length;
		listePizzas[rank-1]=listePizzas[size-1];
		String [][] newList = Arrays.copyOf(listePizzas, size-1);
		return newList;
	}
	
}
