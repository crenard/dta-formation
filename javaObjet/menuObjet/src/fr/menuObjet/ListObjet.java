package fr.menuObjet;

import java.util.*;

public class ListObjet {
    public static void main(String[] args){
        MenuItem menuListe = new MenuListe();
        MenuItem menuAdd = new MenuAdd();
        MenuItem menuRemove = new MenuRemove();

        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
        menuItemList.add(menuListe);
        menuItemList.add(menuAdd);
        menuItemList.add(menuRemove);
        
        System.out.println("Veuillez faire un choix");
        
        for (MenuItem item : menuItemList) 
        	item.printItem();
        
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt(); sc.nextLine();
        
        for (MenuItem item : menuItemList) {
        	if (item.compareTo(choix))
        		item.action();
        }
        sc.close();
    }
}

