public abstract class  Personnage implements Item{
	//private String nom;
	public String nom;
	private double poids;
	private int x,y;
	public Personnage(String nom, double poids){
		this.nom=nom;
		this.poids=poids;
		x = -1;
		y = -1;
	}
	public Personnage(String nom){
		this.nom=nom;
		this.poids=(Math.random()*100+30);
	}

	protected void addPoids(double p){
		if (p>0){
			poids+=p;
		}
	}
	public String toString(){
		String s = String.format("%s %.1f kg",nom,poids) ;
		return s;
	}
	protected double getPoids(){
	return poids;
    }
    
	public int getX(){
		return x;
    }
    public int getY(){
		return y;
    }
    public void setX(int x){
		this.x = x;
    }
    public void setY(int y){
		this.y = y;
    }
    public String getNom(){
		return nom;
    }
}