public class Noms{
	private String [] tabNoms = {"bob", "fil" , "jaz"};
	private static int suiv=1;
    private static int i=0;

	public String getNoms(){
		if (i==3){
			i=0;
			suiv++;
		}
		return tabNoms[i++]+suiv;

	}
}