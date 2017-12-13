import java.util.ArrayList;
import java.util.Scanner;
public class  Avatar extends Personnage{

	private ArrayList<Creature> listeAmis;
	private ArrayList<Acc> listeAcc;
    private Monde monde;
	public Avatar(String nom, double poids,Monde m){
		super(nom,poids);
		listeAmis = new ArrayList<Creature>();
		listeAcc = new ArrayList<Acc>();
		this.monde  = m;
		monde.ajouterItem(this);
    }
    public String toString(){
	return super.toString()+ " "+listeAmis.size() +" ami(s) "+listeAcc.size()+ " accessoire(s)";
    }

    public boolean estAmi(Creature a){
		for(Creature c: listeAmis){
	 	   if(c == a)
			return true;
		}
		return false;
    }
    public void devenirAmi(Creature a){
		if(estAmi(a) == false){
	    	listeAmis.add(a);
	    	monde.supprimerItem(a);
	    	System.out.println(a.getNom()+" devient ami avec "+getNom());
	}
    }
    public void perdreAmi(Creature a){
		if(estAmi(a) == true)
	    listeAmis.remove(a);
    }
    public int getIndAcc(){
		for(int i = 0 ;i<listeAcc.size();i++)
	    	if(listeAcc.get(i) != null)
			return i;
		return -1;
		}

    public void rencontrer(Creature c){ 
		int i = getIndAcc();
		if(i == -1) return;

		if(estAmi(c) == false && listeAcc.get(i).getPoids()>0.5){
	    	devenirAmi(c);
	   		c.ajouteacc(listeAcc.remove(i));
		}
		if(estAmi(c) == true && listeAcc.get(i) == null)
	    	perdreAmi(c);
   		 
   	}
    public double course(){  
		double distance = 0;
		for(Creature i:listeAmis){
	    	i.manger();
	    	distance +=i.getVitesse(); // puisq courir pendant 1h
		}
		return distance;

    }   
    public Creature getCreaturePlusRapide(){
        Creature a = listeAmis.get(0);
		for(Creature b: listeAmis){
	  	  if(b.getVitesse() > a.getVitesse())
				a = b;
		}
		return a;
    }        	
 	public int compterAccMangeable(){
		int cpt = 0;
		for(Acc i:listeAcc)
	   	 if(i.mangeable())
			cpt++;
		return cpt;
    }    
    public void ramasser(Acc a){
		listeAcc.add(a);
		monde.supprimerItem(a); 
		System.out.println(getNom()+" ramasse "+a.getNom());
    }
    public void rencontrerVoisins(){
		ArrayList<Item>voisins = new ArrayList<Item>();
		voisins = monde.getVoisins(this);
		for(Item v: voisins){
	    	if(v instanceof Acc)
				ramasser((Acc)v); 
	    	if(v instanceof Creature)
				devenirAmi((Creature) v);
	    	if( v instanceof Avatar && v != this)
				System.out.println("Avatar salue l'autre avatar");
	}   
				     
    }
    public void seDeplacer(){
	
		System.out.println("### Deplacement de "+getNom()+" ###");
	
		Scanner sc = new Scanner(System.in);
		int i,j;
        
		do{
	    	System.out.println("Saisissez une abscisse entre [0,"+(monde.getTaille()-1)+"] : ");
			i = sc.nextInt();
		}while(i <0 || i >= monde.getTaille());
	
		do{
	    	System.out.println("Saisissez une ordonnée entre [0,"+(monde.getTaille()-1)+"] : ");
			j = sc.nextInt();
			}while(j <0 || j >= monde.getTaille());
		Item a = monde.chercher(i,j);
		if(a instanceof  Creature)
	    devenirAmi((Creature) a);
		if(a instanceof Acc )
			ramasser((Acc) a);
       		rencontrerVoisins();
			System.out.println("Deplacement de "+getNom()+" de ("+getX()+","+getY()+") vers ("+i+","+j+")");
			setX(i);
			setY(j);
	
	
    }
//question 18
      public void ameliorer(){
        
        Scanner choix = new Scanner(System.in);
        int choix_acc=-1, choix_c=-1;
            
        if(this.listeAcc.size()>0 && this.listeAmis.size()>0){
            System.out.println("Quel accessoire voulez vous donner ?! ");
            for(int i=0;i<this.listeAcc.size();i++){
                System.out.println(String.format("%d %s",i,this.listeAcc.get(i)));                
            }
            while(choix_acc < 0 || choix_acc > this.listeAcc.size()-1){
                System.out.print("Entrer le numero de ligne ");
                choix_acc = choix.nextInt();
            }
            
            System.out.println("A quelle créature ?! ");
            for(int i=0;i<this.listeAmis.size();i++){
                System.out.println(String.format("%d %s",i,this.listeAmis.get(i)));                
            }
            while(choix_c < 0 || choix_c > this.listeAmis.size()-1){
                System.out.print("Entrer le numero de la creature  ");
                choix_c = choix.nextInt();
            }
            donner(choix_acc,choix_c);
        }
    }
    
    public void donner(int n_acc, int n_c){
        Acc b = (Acc)listeAcc.get(n_acc);
        Creature c = (Creature)listeAmis.get(n_c);
        c.leSac.ajouter(b);
        listeAcc.remove(b);
        
        System.out.println(String.format("%s a donné %s a %s",this.nom,b.toString(),c.getNom()) );
        
    }
    
    







}