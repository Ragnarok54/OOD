package interfaces;
import shared.Boundary;

public interface IShape extends IObservable{
	
	public void read();
	public void draw();
	public String get();
	public Boundary getBoundingRectangle();
}
