package fr.menuobjet;

public class MenuListe extends MenuItem{

	public String getLibelle(){
		return "Liste des pizzas";
	}
	
	public void faireAction(){
		System.out.println("*Inserer liste des pizzas*");
	}
	

}
