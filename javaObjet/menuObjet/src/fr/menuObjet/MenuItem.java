package fr.menuObjet;

public abstract class MenuItem {
    
	int index;
	
    public abstract void printItem();
    
    public abstract void action();
    
    public boolean compareTo(int i){
    	return i==index;
    }
}
