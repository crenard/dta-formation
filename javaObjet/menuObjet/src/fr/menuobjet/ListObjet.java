package fr.menuobjet;

import java.util.*;

public class ListObjet {
    public static void main(String[] args){
        MenuItem menuListe = new MenuListe();
        MenuItem menuAdd = new MenuAdd();
        MenuItem menuRemove = new MenuRemove();
        int choix;
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
        
        menuItemList.add(menuListe);
        menuItemList.add(menuAdd);
        menuItemList.add(menuRemove);
                
        System.out.println("Veuillez faire un choix");
            
        for (MenuItem item : menuItemList) {
        	System.out.println(menuItemList.indexOf(item) + " : " +item.getLibelle());
        }
        choix = sc.nextInt(); sc.nextLine();
        
        menuItemList.get(choix).faireAction();
	        
        sc.close();
    }
}

