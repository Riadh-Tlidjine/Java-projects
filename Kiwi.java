public class Kiwi  extends Acc {

	private double rayon;

	public Kiwi(){
		super("kiwi");
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