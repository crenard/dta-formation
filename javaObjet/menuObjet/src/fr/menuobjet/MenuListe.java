package fr.menuObjet;

public class MenuListe extends MenuItem{

	public MenuListe(){
		index = 1;
	}
	
	public void printItem(){
		System.out.println("1 : Liste des pizzas");
	}
	
	public void action(){
		System.out.println("*Insérer liste des pizzas*");
	}
	

}
