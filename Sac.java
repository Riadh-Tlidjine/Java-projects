public class Sac extends Acc{
	private int n;
	private Acc [] tab;
	private int nbplace =0;
	private  double poids = 0;



	public Sac(int n){
		super("sac");
			tab=new Acc[ n ];
		}
		//return ...;
	
	public Sac(){
			//super("sac");	
		this((int)(Math.random()*10+1));
		//for(int i = (int)(Math.random()*10+1);i<n;i++)
			//tab[i]=new Acc();
			//nbplace++;
	}
	public int size(){
		return tab.length;
	}
	public void ajouter ( Acc a) {
	    for (int i =0;i<tab.length ; i++) {
 			if (tab[i] == null) {
 				tab[i]=a;
 				nbplace++;

 				return ; 
			}
		}

 		System.out.println ( "Pas de place" ) ;
 	}
 	public Acc obtenir(int i){
 		Acc a = null;
 		if(tab[i] != null){
 			a=tab[i];
 			tab[i]=null;
 		}
 		return tab[i];

 	}

 	public double getPoids(){
 		for( Acc i: tab)
 			if(i != null)
 			poids+= i.getPoids();
 		return poids;
 	}
 	public String toString(){
		String s = super.toString()+ String.format(" contient %d accessoires sur %d places",nbplace,size());
		for(Acc i: tab)
			if(i != null)
			s=s+"\n"+ i.toString();
		
        return s; 		
 	}
 	public boolean mangeable(){
	return false;
    }
    public void suppacc(int i){
	tab[i] = null;
    }

}