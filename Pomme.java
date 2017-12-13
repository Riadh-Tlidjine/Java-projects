public class Pomme  extends Acc {

	private double rayon;

	public Pomme(){
		super("pomme");
		rayon=(Math.random()*4+3);

	}
	public double getPoids(){
		return (Math.PI*rayon*rayon*rayon*4/3000);

	}
	public boolean mangeable(){
		return true;
	}
	public String toString(){
		String s=super.toString() + String.format(" %.1fcm",rayon);
    
        return s;

	}

}