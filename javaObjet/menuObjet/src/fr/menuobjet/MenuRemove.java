package fr.menuobjet;

public class MenuRemove extends MenuItem{

	public String getLibelle(){
		return "Retirer une pizza";
	}
	
	public void faireAction(){
		System.out.println("*Faire semblant de retirer une pizza*");
	}
}
