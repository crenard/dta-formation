package fr.menuObjet;

import java.util.*;

public class ListObjet {
    public static void main(String[] args){
        MenuItem menuListe = new MenuListe();
        MenuItem menuAdd = new MenuAdd();
        MenuItem menuRemove = new MenuRemove();
        int choix;
        boolean choixValide = false;
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
        
        menuItemList.add(menuListe);
        menuItemList.add(menuAdd);
        menuItemList.add(menuRemove);
        
        
        while (!choixValide) {

            System.out.println("Veuillez faire un choix");
            
	        for (MenuItem item : menuItemList) 
	        	item.printItem();
	        
	        choix = sc.nextInt(); sc.nextLine();
	        
	        for (MenuItem item : menuItemList) {
	        	if (item.compareTo(choix)){
	        		item.action();
	        		choixValide = true;
	        	}
	        }
        }
        sc.close();
    }
}

