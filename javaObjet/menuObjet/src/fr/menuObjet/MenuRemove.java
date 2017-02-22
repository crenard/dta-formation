package fr.menuObjet;

public class MenuRemove extends MenuItem{


	public MenuRemove(){
		index = 3;
	}
	
	public void printItem(){
		System.out.println("3 : Retirer une pizza");
	}
	
	public void action(){
		System.out.println("*Faire semblant de retirer une pizza*");
	}
}
