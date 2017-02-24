package fr.menuobjet;

public class MenuAdd extends MenuItem{

	public String getLibelle(){
		return "Ajouter une pizza";
	}
	
	public void faireAction(){
		System.out.println("*Faire semblant d'ajouter une pizza*");
	}
}
