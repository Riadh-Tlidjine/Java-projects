public abstract class Acc implements Mangeable,Item {
    private static int cpt = 0;
    private int numero ;
    public String categorie;
    private int x,y;

    public Acc(String categorie){
        this.categorie=categorie;
        cpt++;
        numero = cpt;
        x = -1;
        y =- 1;
        
    }

    public abstract double getPoids();
    public String toString(){
        String s = String.format("%s No %d %.2fkg",categorie,numero,getPoids());
        return s;
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
        return categorie;
    }
}
