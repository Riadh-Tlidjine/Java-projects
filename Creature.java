public class Creature extends Personnage {

	//private Sac leSac;
	public Sac leSac; //question 18 public
	private double poids = 0;
	public Creature(){
		super(new Nom().getNoms());
		leSac = new Sac();
	}
	public void ajouteacc(Acc a){
		poids= leSac.getPoids() + a.getPoids();
		if ( poids < getPoids()/2){
			leSac.ajouter(a);
		}
		else 
	    System.out.println("Trop lourd");
	}

    public double getVitesse(){
		double pc = getPoids();
		double ps = leSac.getPoids();
		double v = 0; 
		v = pc/4.0 - ps;
		if(v < 0)
	   	 v = 0;
		return v;
    }

    public void manger(){
		int i;
		for(i = 0;i< leSac.size();i++){
	   	 if(leSac.obtenir(i) != null)
	   		 if(leSac.obtenir(i).mangeable()){
				addPoids(leSac.obtenir(i).getPoids());leSac.suppacc(i);
				return;
	    	 }
		}
    }
    public void courir(){
        System.out.println(super.toString()+String.format(" court à vitesse %.2f km/h",getVitesse()) +" avec "+ leSac.toString());
    }

}