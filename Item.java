public interface Item{
    public abstract int getX();
    public abstract int getY();
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract String getNom();
    public default int distance(Item item){
	return Math.abs(getX()-item.getX())+Math.abs(getY()-item.getY());
    }
}
	
	// 2 classes Acc et personnage