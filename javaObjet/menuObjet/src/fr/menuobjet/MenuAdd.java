package fr.menuObjet;

public class MenuAdd extends MenuItem{

	public MenuAdd(){
		index = 2;
	}
	
	public void printItem(){
		System.out.println("2 : Ajouter une pizza");
	}
	
	public void action(){
		System.out.println("*Faire semblant d'ajouter une pizza*");
	}
}
