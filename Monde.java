import java.util.ArrayList;
public class Monde {
	private ArrayList<Item> listeItems;
	private int taille;
	public Monde(int taille){
		listeItems = new ArrayList<Item>();
		this.taille = taille;
    }
    public int getPositionAlea(){
		return (int)(Math.random()*taille);
    }
    public void ajouterItem(Item item){
		if(item == null)
	    return;
		item.setX(getPositionAlea());
		item.setY(getPositionAlea());
		listeItems.add(item);
    }
    
    public void supprimerItem(Item item){
		listeItems.remove(item);
		item.setX(-1); 
		item.setY(-1);
    }
    public Item chercher(int x, int y){
		for(Item i: listeItems){
	    	if(i.getX() == x && i.getY() == y)
			return i;
		}
		return null;
    }
    public ArrayList<Item> getVoisins(Item item){
		ArrayList<Item> voisins = new ArrayList<Item>();
		for(Item i:listeItems){
	    	if(i.distance(item) < 2)
			voisins.add(i);
		}
		return voisins;
    }
    private static String getNomCourt(String nom){
		String name = "    ";
		if(nom.length() == 4)
	    	return nom;
		if(nom.length()> 4)
	   		return nom.substring(0,4);
		else{
	    	name = nom+" ";
	    if(nom.length() < 3){
			name = " "+name;
		if(nom.length() <= 1 ){
		    name =" "+name;
		}
	    }
		}
		return name;
    }



    public void afficher(){
	
		System.out.print(" |");
		for(int i =0;i<taille;i++){
	    	System.out.print("  "+i+" |");
		}
		System.out.println();
	
		for(int i=0;i<taille;i++){
	    	System.out.print(i+"|");
	    	for(int j=0;j<taille;j++){
				if(chercher(i,j) != null){
		    	System.out.print(getNomCourt((chercher(i,j)).getNom())+"|");

			}else
		    System.out.print("    |");
	    	}
	    	System.out.println();
		}
    }

	public int getTaille(){
		return taille;
    }

}
